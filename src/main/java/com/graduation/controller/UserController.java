package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.domain.User;
import com.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	// 充值
	@RequestMapping("/recharge")
	@ResponseBody
	public Map<String, Object> recharge(@RequestBody Map<String, String> params) {
		String userId = params.get("userId");
		String money = params.get("money");
		Map<String, Object> result = new HashMap<>();
		if ((userId == null || userId.length() <= 0) || (money == null || money.length() <= 0)) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		String reg_money = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{0,2})?$";// 金额正则,可以没有小数，小数最多不超过两位
		Pattern pattern = Pattern.compile(reg_money);
		Matcher matcher = pattern.matcher(money);
		boolean ismatch = matcher.matches();
		if (!ismatch) {
			result.put("msg", Constants.Result.JEGSBZQ);
			return result;
		}
		BigDecimal rechargeMoney = new BigDecimal(money);
		Map<String, Object> user = userService.getUserByUserId(userId);
		BigDecimal myMoney = new BigDecimal(user.get("money").toString());
		BigDecimal newMoney = rechargeMoney.add(myMoney);
		userService.setMoneyByUserId(userId,newMoney);
		result.put("success", true);
		return result;
	}
}
