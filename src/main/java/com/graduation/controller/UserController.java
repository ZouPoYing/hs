package com.graduation.controller;

import com.graduation.domain.User;
import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
			result.put("msg", "参数不能为空");
			return result;
		}
		int userCount = userService.queryUserCountByPhoneNumber(phoneNumber);
		if (userCount == 0) {
			userService.insertUser(nickName,"vip",phoneNumber,avatarUrl);
		}
		result.put("user", userService.queryUserByPhoneNumber(phoneNumber));
		result.put("success", true);
		return result;
	}
	
	// 通过userId查询user
	@RequestMapping("/queryUserByUserId")
	@ResponseBody
	public User queryUserByUserId(@RequestBody String userid) {
		if(userid == "") {
			return null;
		} else {
			int userId=Integer.parseInt(userid);
			User user = userService.queryUserByUserId(userId);
			System.out.println(user.toString());
			return user;
		}
	}
	

	
	// 修改用户信息模块 根据用户的id修改用户名
    @PostMapping("/user/updateNameById")
	@ResponseBody
	public String updateNameById(@RequestBody User user) { 
    	System.out.println(user);
    	userService.updateNameById(user.getUserId(), user.getNickName());
		return "修改成功";
	}
}
