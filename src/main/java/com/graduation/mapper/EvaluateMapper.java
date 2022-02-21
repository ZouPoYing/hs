package com.graduation.mapper;

import com.graduation.domain.Evaluate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluateMapper {

    @Insert("insert into evaluate(level,img,message) values(#{level},#{img},#{message})")
    @Options(useGeneratedKeys=true, keyProperty="evaluateId", keyColumn="evaluate_id")
    public void insertEvaluate(Evaluate evaluate);

    @Select("select e.evaluate_id,e.img,e.level,e.message,o.barber_id,o.user_id,o.order_type,o.end_time from evaluate e " +
            "left join hs.order o on e.evaluate_id=o.evaluate_id order by o.end_time desc LIMIT ${offset},${rows}")
    public List<Map<String, Object>> getEvaluateByLimit(String offset, String rows);

    @Select("select e.evaluate_id,e.img,e.level,e.message,o.barber_id,o.user_id,ifnull(o.order_type,'假数据洗剪吹') as order_type," +
            "ifnull(o.end_time,sysdate()) as end_time,ifnull(b.barber_name,'Tony Wang（假数据）') as barber_name," +
            "ifnull(b.barber_head,'http://localhost:9191/hs/1_1645157046642_1645157046642.9j.png') as barber_head " +
            "from evaluate e left join hs.order o on e.evaluate_id=o.evaluate_id left join barber b on o.barber_id=b.barber_id order by o.end_time desc")
    public List<Map<String, Object>> getEvaluate();

    @Select("select e.evaluate_id,e.img,e.level,e.message,o.barber_id,o.user_id,ifnull(o.order_type,'假数据洗剪吹') as order_type," +
            "ifnull(o.end_time,sysdate()) as end_time,ifnull(b.barber_name,'Tony Wang（假数据）') as barber_name," +
            "ifnull(b.barber_head,'http://localhost:9191/hs/1_1645157046642_1645157046642.9j.png') as barber_head " +
            "from evaluate e left join hs.order o on e.evaluate_id=o.evaluate_id left join barber b on o.barber_id=b.barber_id " +
            " where e.evaluate_id = #{evaluateId} order by o.end_time desc")
    public Map<String, Object> getEvaluateDeatilByEvaluateId(String evaluateId);
}
