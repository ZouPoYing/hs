package com.graduation.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.graduation.domain.App;

@Mapper
public interface AppMapper {

	@Select("select * from app where type='my-menu' and auth <= (select CASE WHEN user_type='vip' THEN 2 " +
			"WHEN user_type='管理员' THEN 9 ELSE 0 END AS user_type from user where phone_number=#{phoneNumber})")
	public List<Map<String, Object>> getAppByPhoneNumber(String phoneNumber);

	@Select("select * from app where type='my-menu' and auth <= #{auth}")
	public List<Map<String, Object>> getAppByAuth(String auth);

	@Select("select * from app where type='banner'")
	@Results({
            @Result(property = "id", column = "id"),
			@Result(property = "img", column = "img"),
			@Result(property = "title", column = "title"),
            @Result(property = "link", column = "link"),
            @Result(property = "type", column = "type") })
	public List<App> queryAllAppBannersList();
	
	@Select("select * from app where type='recommend'")
	@Results({
            @Result(property = "id", column = "id"),
			@Result(property = "img", column = "img"),
			@Result(property = "title", column = "title"),
            @Result(property = "link", column = "link"),
            @Result(property = "type", column = "type") })
	public List<App> queryAllAppRecommendsList();
}
