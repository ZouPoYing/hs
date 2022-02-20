package com.graduation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.User;
import com.graduation.mapper.UserMapper;

import java.util.List;
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

	public void updateMyinfoByPhoneNumber(String phoneNumber, String sex, String year, String hair, String face, String job, String education){
		mapper.updateMyinfoByPhoneNumber(phoneNumber,sex, year, hair, face, job, education);
	}

	public Map<String, Object> getMyinfoByPhoneNumber(String phoneNumber){
		return mapper.getMyinfoByPhoneNumber(phoneNumber);
	}

	public List<Map<String, Object>> getVipInfo(){
		return mapper.getVipInfo();
	}

	public Map<String, Object> getUserByUserId(String userId){
		return mapper.getUserByUserId(userId);
	}

}
