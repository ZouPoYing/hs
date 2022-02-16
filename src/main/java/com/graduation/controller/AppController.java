package com.graduation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.domain.App;
import com.graduation.service.AppService;

@RestController
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/app")
public class AppController {

	@Autowired
	private AppService appService;

	@RequestMapping("/getAppByPhoneNumber")
	public List<Map<String, Object>> getAppByPhoneNumber(@RequestBody Map<String, String> params) {
		String phoneNumber = params.get("phoneNumber");
		if (phoneNumber==null) {
			return appService.getAppByAuth("0");
		}
		return appService.getAppByPhoneNumber(phoneNumber);
	}

	// 获取app banners数据
	@RequestMapping("/app/bannersList")
	public List<App> queryAllAppBannersList()
	{
		List<App> banners = appService.queryAllAppBannersList();
		System.out.println(banners.toString());
		return banners;
	}
	
	// 获取app recommends数据
	@RequestMapping("/app/recommendsList")
	public List<App> queryAllAppRecommendsList()
	{
		List<App> recommends = appService.queryAllAppRecommendsList();
		System.out.println(recommends.toString());
		return recommends;
	}
}
