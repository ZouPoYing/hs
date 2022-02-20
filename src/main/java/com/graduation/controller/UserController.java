package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.domain.User;
import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	// 注册并返回用户数据
	@RequestMapping("/register")
	public Map<String, Object> register(@RequestBody Map<String, String> params) {
		String phoneNumber = params.get("phoneNumber");
		String nickName = params.get("nickName");
		String avatarUrl = params.get("avatarUrl");
		Map<String, Object> result = new HashMap<>();
		if (phoneNumber.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		int userCount = userService.queryUserCountByPhoneNumber(phoneNumber);
		if (userCount == 0) {
			userService.insertUser(nickName, Constants.UserType.VIP,phoneNumber,avatarUrl);
		}
		result.put("user", userService.queryUserByPhoneNumber(phoneNumber));
		result.put("success", true);
		return result;
	}

	// 通过电话号码更新个人档案
	@RequestMapping("/updateMyinfoByPhoneNumber")
	@ResponseBody
	public Map<String, Object> updateMyinfoByPhoneNumber(@RequestBody Map<String, String> params) {
		String phoneNumber = params.get("phoneNumber");
		String info = params.get("info");
		List<String> infoList = Arrays.asList(info.split(","));
		Map<String, Object> result = new HashMap<>();
		if (phoneNumber.isEmpty() || info.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		userService.updateMyinfoByPhoneNumber(phoneNumber,infoList.get(0),infoList.get(1),infoList.get(2),infoList.get(3),infoList.get(4),infoList.get(5));
		result.put("success", true);
		return result;
	}

	// 通过电话号码获取个人档案，默认返回选项的第一项
	@RequestMapping("/getMyinfoByPhoneNumber")
	@ResponseBody
	public Map<String, Object> getMyinfoByPhoneNumber(@RequestBody Map<String, String> params) {
		String phoneNumber = params.get("phoneNumber");
		Map<String, Object> result = new HashMap<>();
		if (phoneNumber.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		result = userService.getMyinfoByPhoneNumber(phoneNumber);
		return result;
	}

	// 获取vip信息
	@RequestMapping("/getVipInfo")
	@ResponseBody
	public List<Map<String, Object>> getVipInfo() {
		return userService.getVipInfo();
	}

	// 通过userId查询user
	@RequestMapping("/getUserByUserId")
	@ResponseBody
	public Map<String, Object> getUserByUserId(@RequestBody Map<String, String> params) {
		String userId = params.get("userId");
		Map<String, Object> result = new HashMap<>();
		if (userId.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		result = userService.getUserByUserId(userId);
		result.put("success", true);
		return result;
	}

}
