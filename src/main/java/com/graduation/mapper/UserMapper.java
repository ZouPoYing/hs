package com.graduation.mapper;

import com.graduation.domain.User;
import org.apache.ibatis.annotations.*;

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

	@Select("select * from user where user_id=#{userId}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByUserId(int userId);
	
	@Select("select * from user where user_email=#{email}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByEmail(String email);
	
//	@Insert("insert into user (user_password, user_email) values (#{password} ,#{email})")
//	@Options(useGeneratedKeys=true)
//	void insertUser(@Param("email") String email,@Param("password") String password);
	
	@Select("select * from user where user_email=#{email} and user_password=#{password}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
	@Update("update user set user_password=#{password} WHERE user_email =#{email}")
    void updateUserPasswordByEmail(String password, String email);
	
	@Update("update user set user_name=#{userName} WHERE user_id =#{userId}")
	void updateNameById(int userId,String userName);
	
}