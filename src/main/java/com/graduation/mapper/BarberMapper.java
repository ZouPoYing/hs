package com.graduation.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BarberMapper {

    @Select("select * from barber order by is_work desc")
    @Results({
            @Result(property = "describe", column = "skill_describe")})
    public List<Map<String, Object>> getBarbers();

    @Select("select TIMESTAMPDIFF(YEAR,DATE_FORMAT(entry_time, \"%Y-%m-%d %H:%i:%s\"),DATE_FORMAT(now(), \"%Y-%m-%d %H:%i:%s\"))+1 as year,barber.* from barber where barber_id=#{barberId}")
    @Results({
            @Result(property = "describe", column = "skill_describe")})
    public Map<String, Object> getBarberByBarberId(String barberId);

    @Insert("insert into barber(barber_head,barber_back,barber_name,skill,star_time,end_time,is_work,position,skill_describe) " +
            "values(#{barberHead},#{barberBack},#{barberName},#{skill},#{starTime},#{endTime},#{isWork},#{position},#{describe})")
    public void insertBarber(String barberHead,String barberBack,String barberName,String skill,String starTime,String endTime,String isWork,String position,String describe);

    @Delete("DELETE FROM BARBER WHERE barber_id=#{barberId}")
    public void deleteBarberByBarberId(String barberId);

    @Update("update barber set barber_head=#{barberHead},barber_back=#{barberBack},barber_name=#{barberName},skill=#{skill}" +
            ",star_time=#{starTime},end_time=#{endTime},is_work=#{isWork},position=#{position},skill_describe=#{describe} WHERE barber_id =#{barberId}")
    public void updateBarberByBarberId(String barberId,String barberHead,String barberBack,String barberName,String skill,String starTime,String endTime,String isWork,String position,String describe);

    @Select("select TIMESTAMPDIFF(YEAR,DATE_FORMAT(entry_time, \"%Y-%m-%d %H:%i:%s\"),DATE_FORMAT(now(), \"%Y-%m-%d %H:%i:%s\"))+1 as year,barber.* " +
            "from barber where is_work = '是' and star_time < DATE_FORMAT(SYSDATE(), \"%H:%i\") and end_time > DATE_FORMAT(SYSDATE(), \"%H:%i\") ${sub}")
    @Results({
            @Result(property = "describe", column = "skill_describe")})
    public List<Map<String, Object>> getWorkBarbers(String sub);

}
