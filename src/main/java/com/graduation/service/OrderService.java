package com.graduation.service;

import com.graduation.domain.Order;
import com.graduation.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired(required = false)
    private OrderMapper orderMapper;

    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public Boolean hasOrderByUserIdAndStatusSub(String userId,String sub) {
        return orderMapper.getOrderCountByUserIdAndStatusSub(userId, sub) != 0;
    }

    public Boolean hasOrderByBarberIdAndStatusSub(String barberId,String sub) {
        return orderMapper.getOrderCountByBarberIdAndStatusSub(barberId, sub) != 0;
    }

    public Boolean hasOtherOrderByBarberIdAndStatusSub(String barberId,String sub) {
        return orderMapper.getOrderCountByBarberIdAndStatusSub(barberId, sub) > 1;
    }

    public void setStatusByOrderId(Integer orderId,String status) {
        orderMapper.setStatusByOrderId(orderId, status);
    }

    public int getOrderCountByBarberIdAndStatusSub(String barberId,String sub) {
        return orderMapper.getOrderCountByBarberIdAndStatusSub(barberId, sub);
    }

    public List<Map<String, Object>> getOrderByUserIdAndStatus(String userId, String status) {
        return orderMapper.getOrderByUserIdAndStatus(userId,status);
    }

    public List<Map<String, Object>> getOrderSortByBarberIdAndStatusSub(String barberId, String sub) {
        return orderMapper.getOrderSortByBarberIdAndStatusSub(barberId,sub);
    }

    public void setStatusAndEndTimeByOrderId(Integer orderId, String status) {
        orderMapper.setStatusAndEndTimeByOrderId(orderId, status);
    }

    public void setStatusAndPayTimeByOrderId(Integer orderId, String status) {
        orderMapper.setStatusAndPayTimeByOrderId(orderId, status);
    }

    public Map<String, Object> getOrderByOrderId(String orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }

    public List<Map<String, Object>> getLineOrderByBarberIdAndLimitSub(String orderId, String limitSub) {
        return orderMapper.getLineOrderByBarberIdAndLimitSub(orderId, limitSub);
    }

    public Map<String, Object> getOrderDetailByOrderId(String orderId) {
        return orderMapper.getOrderDetailByOrderId(orderId);
    }

    public void setEvaluate(String orderId, Integer evaluateId, String status) {
        orderMapper.setEvaluate(orderId, evaluateId, status);
    }


}
