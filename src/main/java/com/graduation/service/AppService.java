package com.graduation.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.App;
import com.graduation.mapper.AppMapper;

@Service
public class AppService {

	@Autowired(required = false)
	private AppMapper mapper;

	public List<Map<String, Object>> getAppByPhoneNumber(String phoneNumber){
		return mapper.getAppByPhoneNumber(phoneNumber);
	}

	public List<Map<String, Object>> getAppByType(String type){
		return mapper.getAppByType(type);
	}

	public void setCommon(){
		mapper.setCommon();
	}

	public void setNewYear(){
		mapper.setNewYear();
	}

	public List<Map<String, Object>> getAppLikeType(String type){
		return mapper.getAppLikeType(type);
	}

	public void updatePositionPrice(String positionPrice1,String positionPrice2,String positionPrice3,String positionPrice4){
		mapper.updatePositionPrice(positionPrice1,positionPrice2,positionPrice3,positionPrice4);
	}

	public void updateSkillPrice(String skillPrice1,String skillPrice2,String skillPrice3,String skillPrice4){
		mapper.updateSkillPrice(skillPrice1,skillPrice2,skillPrice3,skillPrice4);
	}

	public List<Map<String, Object>> getAppByAuth(String auth){
		return mapper.getAppByAuth(auth);
	}

	public String getPriceById(String id){
		return mapper.getPriceById(id);
	}

}
