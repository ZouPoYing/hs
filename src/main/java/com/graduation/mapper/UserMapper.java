package com.graduation.mapper;

import com.graduation.domain.User;
import org.apache.ibatis.annotations.*;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

	@Select("select count(1) from user where phone_number=#{phoneNumber}")
	public int queryUserCountByPhoneNumber(String phoneNumber);

	@Insert("insert into user (nick_name,user_type,phone_number,avatar_url) values " +
			"(#{nickName} ,#{userType} ,#{phoneNumber} ,#{avatarUrl})")
	@Options(useGeneratedKeys=true)
	public void insertUser(String nickName,String userType,String phoneNumber,String avatarUrl);

	@Select("select * from user where phone_number=#{phoneNumber}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "nickName", column = "nick_name"),
			@Result(property = "userType", column = "user_type"),
			@Result(property = "phoneNumber", column = "phone_number"),
			@Result(property = "avatarUrl", column = "avatar_url") })
	public Map<String, Object> queryUserByPhoneNumber(String phoneNumber);

	@Update("update user set sex=#{sex},year=#{year},hair=#{hair},face=#{face},job=#{job},education=#{education} WHERE phone_number =#{phoneNumber}")
	public void updateMyinfoByPhoneNumber(String phoneNumber, String sex, String year, String hair, String face, String job, String education);

	@Select("select concat(sex,',',year,',',hair,',',face,',',job,',',education) as info,t.* from (select ifnull(MAX(sex),'男') as sex," +
			"ifnull(year,'≥70后') as year,ifnull(hair,'短发') as hair,ifnull(face,'椭圆形') as face,ifnull(job,'程序员') as job," +
			"ifnull(education,'高中及以下') as education from user where phone_number=#{phoneNumber}) t")
	public Map<String, Object> getMyinfoByPhoneNumber(String phoneNumber);

	@Select("select user_id as userId,nick_name as nickName,user_type as userType,phone_number as phoneNumber," +
			"avatar_url as avatarUrl from user where user_type='vip'")
	public List<Map<String, Object>> getVipInfo();

	@Select("select * from user where user_id=#{userId}")
	@Results({
			@Result(property = "userId", column = "user_id"),
			@Result(property = "nickName", column = "nick_name"),
			@Result(property = "userType", column = "user_type"),
			@Result(property = "phoneNumber", column = "phone_number"),
			@Result(property = "avatarUrl", column = "avatar_url") })
	public Map<String, Object> getUserByUserId(String userId);
	
}