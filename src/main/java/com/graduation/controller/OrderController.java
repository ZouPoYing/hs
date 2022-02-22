package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.domain.Order;
import com.graduation.service.BarberService;
import com.graduation.service.OrderService;
import com.graduation.service.UserService;
import com.graduation.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.MapUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BarberService barberService;

    @Autowired
    private UserService userService;

    // 排队
    @RequestMapping("/insertOrder")
    public Map<String, Object> insertOrder(@RequestBody Map<String, String> params) throws Exception {
        String userId = params.get("userId");
        String barberId = params.get("barberId");
        String price = params.get("price");
        String orderType = params.get("orderType");
        Map<String, Object> result = new HashMap<>();
        if (userId.isEmpty() || barberId.isEmpty() || price.isEmpty() || orderType.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        Map<String, Object> barber = barberService.getBarberByBarberId(barberId);
        if (!MyUtil.isWork(barber.get("star_time"),barber.get("end_time"))) {
            result.put("msg", Constants.Result.LFSBZGZSJN);
            return result;
        }
        if (orderService.hasOrderByUserIdAndStatusSub(userId,Constants.StatusSub.YHYDDZZJXZ)) {
            result.put("msg", Constants.Result.NYDDZZJXZ);
            return result;
        }
        Order order = new Order(null,Integer.valueOf(userId),Integer.parseInt(barberId),null,Constants.StatusType.PD,price,orderType,null,null);
        orderService.insertOrder(order);
        if (!orderService.hasOtherOrderByBarberIdAndStatusSub(barberId,Constants.StatusSub.LFSYDDZZJXZ)) {
            orderService.setStatusByOrderId(order.getOrderId(), Constants.StatusType.FWZ);
        }
        result.put("success", true);
        return result;
    }

    // 通过用户id 和 状态 获取订单详情
    @RequestMapping("/getOrderDetailByUserIdAndStatus")
    public List<Map<String, Object>> getOrderDetailByUserIdAndStatus(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
        String status = params.get("status");
        if (userId.isEmpty() || status.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<>();
        List<Map<String, Object>> orders = orderService.getOrderByUserIdAndStatus(userId,MyUtil.switchStatus(status));
        for (Map<String, Object> order: orders ) {
            order.put("time", MyUtil.timeFormat(order.get("start_time").toString()));
            if ("0".equals(status)) {
                List<Map<String, Object>> orderSort = orderService.getOrderSortByBarberIdAndStatusSub(order.get("barber_id").toString(),Constants.StatusSub.PDPX);
                for (Map<String, Object> map : orderSort ) {
                    if (order.get("user_id").equals(map.get("user_id"))) {
                        order.put("sort", map.get("rownum"));
                        break;
                    }
                }
                order.put("line", orderSort.size());
            } else if ("2".equals(status)) {
                order.put("pay_time", MyUtil.timeFormat(order.get("pay_time").toString()));
            } else if ("3".equals(status)) {
                order.put("pay_time", MyUtil.timeFormat(order.get("pay_time").toString()));
                order.put("evaluate_time", MyUtil.timeFormat(order.get("end_time").toString()));
            } else if ("4".equals(status)) {
                order.put("cancel_time", MyUtil.timeFormat(order.get("end_time").toString()));
            }
            result.add(order);
        }
        return result;
    }

    // 取消排队
    @RequestMapping("/cancelLine")
    public Map<String, Object> cancelLine(@RequestBody Map<String, String> params) {
        String orderId = params.get("orderId");
        Map<String, Object> result = new HashMap<>();
        if (orderId.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        orderService.setStatusAndEndTimeByOrderId(Integer.parseInt(orderId),Constants.StatusType.QXPD);
        result.put("success", true);
        return result;
    }

    // 支付
    @RequestMapping("/pay")
    public Map<String, Object> pay(@RequestBody Map<String, String> params) {
        String orderId = params.get("orderId");
        Map<String, Object> result = new HashMap<>();
        if (orderId.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        Map<String, Object> order = orderService.getOrderByOrderId(orderId);
        Map<String, Object> user = userService.getUserByUserId(order.get("user_id").toString());
        BigDecimal payMoney = new BigDecimal(order.get("price").toString());
        BigDecimal myMoney = new BigDecimal(user.get("money").toString());
        if (payMoney.compareTo(myMoney) > 0) {
            result.put("msg", Constants.Result.YEBZ);
            return result;
        }
        orderService.setStatusAndPayTimeByOrderId(Integer.parseInt(orderId),Constants.StatusType.DPJ);
        userService.setMoneyByUserId(user.get("userId").toString(),myMoney.subtract(payMoney));
        List<Map<String, Object>> allLineOrder = orderService.getLineOrderByBarberIdAndLimitSub(order.get("barber_id").toString(),Constants.LimitSub.HQDYGPDDDD);
        if (allLineOrder.size() != 0) {
            if (!MapUtils.isEmpty(allLineOrder.get(0))) {
                orderService.setStatusByOrderId(Integer.valueOf(allLineOrder.get(0).get("order_id").toString()),Constants.StatusType.FWZ);
            }
        }
        result.put("success", true);
        return result;
    }

    // 获取待评价信息
    @RequestMapping("/getOrderDetailByOrderId")
    public Map<String, Object> getOrderDetailByOrderId(@RequestBody Map<String, String> params) throws Exception {
        String orderId = params.get("orderId");
        Map<String, Object> result = new HashMap<>();
        if (orderId.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        result = orderService.getOrderDetailByOrderId(orderId);
        result.put("success", true);
        return result;
    }

}
