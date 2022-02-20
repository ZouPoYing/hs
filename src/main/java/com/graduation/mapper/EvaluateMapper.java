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
}
