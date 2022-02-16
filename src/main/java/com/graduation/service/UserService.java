package com.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.User;
import com.graduation.mapper.UserMapper;

import java.util.Map;

@Service
public class UserService {

	@Autowired(required = false)
	private UserMapper mapper;

	public int queryUserCountByPhoneNumber(String phoneNumber){
		return mapper.queryUserCountByPhoneNumber(phoneNumber);
	}

	public void insertUser(String nickName,String userType,String phoneNumber,String avatarUrl){
		mapper.insertUser(nickName,userType,phoneNumber,avatarUrl);
	}

	public Map<String, Object> queryUserByPhoneNumber(String phoneNumber){
		return mapper.queryUserByPhoneNumber(phoneNumber);
	}

	
	public User queryUserByUserId(int userId){
		User user=mapper.queryUserByUserId(userId);
		return user;
	}
	
	public void updateNameById(int userId, String userName) {
		mapper.updateNameById(userId, userName);
	}

}
