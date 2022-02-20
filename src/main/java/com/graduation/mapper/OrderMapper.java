package com.graduation.mapper;

import com.graduation.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    @Insert("insert into hs.order(user_id,barber_id,status,price,order_type) values(#{userId},#{barberId},#{status},#{price},#{orderType})")
    @Options(useGeneratedKeys=true, keyProperty="orderId", keyColumn="order_id")
    public void insertOrder(Order order);

    @Select("select count(1) from hs.order where user_id = #{userId} ${sub}")
    public int getOrderCountByUserIdAndStatusSub(String userId,String sub);

    @Select("select count(1) from hs.order where barber_id = #{barberId} ${sub}")
    public int getOrderCountByBarberIdAndStatusSub(String barberId,String sub);

    @Update("update hs.order set status=#{status} where order_id=#{orderId} ")
    public void setStatusByOrderId(Integer orderId,String status);

    @Select("select barber.barber_name,barber.position,barber.barber_head,order.price,order.order_type,order.start_time,order.barber_id,order.user_id," +
            "order.order_id,order.end_time,order.pay_time from hs.order left join user on order.user_id=user.user_id left join barber on order.barber_id=barber.barber_id where " +
            "order.user_id = #{userId} and order.status = #{status} order by order.start_time desc")
    public List<Map<String, Object>> getOrderByUserIdAndStatus(String userId, String status);


    @Select("select (@rownum := @rownum + 1) as rownum,t.* from (select * from hs.order where barber_id = #{barberId} ${sub} " +
            "order by start_time) t,( select @rownum := 0 ) r")
    public List<Map<String, Object>> getOrderSortByBarberIdAndStatusSub(String barberId, String sub);

    @Update("update hs.order set status=#{status}, end_time=now() where order_id=#{orderId} ")
    public void setStatusAndEndTimeByOrderId(Integer orderId,String status);

    @Update("update hs.order set status=#{status}, pay_time=now() where order_id=#{orderId} ")
    public void setStatusAndPayTimeByOrderId(Integer orderId,String status);

    @Select("select * from hs.order where order_id = #{orderId}")
    public Map<String, Object> getOrderByOrderId(String orderId);

    @Select("select * from hs.order where barber_id = #{barberId} and status = '排队' ${limitSub}")
    public List<Map<String, Object>> getLineOrderByBarberIdAndLimitSub(String barberId,String limitSub);

    @Select("select barber.barber_name,barber.position,barber.barber_head,order.price,order.order_type,order.start_time,order.barber_id,order.user_id," +
            "order.order_id,order.end_time,order.pay_time from hs.order left join user on order.user_id=user.user_id left join barber on " +
            "order.barber_id=barber.barber_id where order.order_id = #{orderId}")
    public Map<String, Object> getOrderDetailByOrderId(String orderId);

    @Update("update hs.order set status=#{status}, end_time=now(), evaluate_id=#{evaluateId} where order_id=#{orderId} ")
    public void setEvaluate(String orderId, Integer evaluateId, String status);
}
