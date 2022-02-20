package com.graduation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.graduation.bean.Constants;
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

	@RequestMapping("/getAppTabbar")
	public List<Map<String, Object>> getAppType() {
		List<Map<String, Object>> apps = appService.getAppByType(Constants.AppType.DBDHL);
		List<Map<String, Object>> tabbars = new ArrayList<>();
		for (Map<String, Object> app : apps) {
			Map<String, Object> tabbar = new HashMap<>();
			tabbar.put("pagePath", app.get("link"));
			tabbar.put("text", app.get("title"));
			tabbar.put("iconPath", app.get("img"));
			tabbar.put("selectedIconPath", app.get("img").toString().replace(".png", "-active.png"));
			tabbars.add(tabbar);
		}
		return tabbars;
	}

	@RequestMapping("/getHaircuter")
	public List<Map<String, Object>> getHaircuter() {
		return appService.getAppByType(Constants.AppType.FXSLBT);
	}

	@RequestMapping("/setCommon")
	public Map<String, Object> setCommon() {
		Map<String, Object> result = new HashMap<>();
		appService.setCommon();
		result.put("success", true);
		return result;
	}

	@RequestMapping("/setNewYear")
	public Map<String, Object> setNewYear() {
		Map<String, Object> result = new HashMap<>();
		appService.setNewYear();
		result.put("success", true);
		return result;
	}

	@RequestMapping("/getPriceSet")
	public Map<String, Object> getPriceSet() {
		List<Map<String, Object>> priceSet =  appService.getAppLikeType(Constants.AppType.JG);
		Map<String, Object> result = new HashMap<>();
		for (Map<String, Object> map : priceSet ) {
			result.put(map.get("type").toString(), map.get("img"));
		}
		result.put("success", true);
		return result;
	}

	@RequestMapping("/updatePositionPrice")
	public Map<String, Object> updatePositionPrice(@RequestBody Map<String, String> params) {
		String positionPrice1 = params.get("positionPrice1");
		String positionPrice2 = params.get("positionPrice2");
		String positionPrice3 = params.get("positionPrice3");
		String positionPrice4 = params.get("positionPrice4");
		Map<String, Object> result = new HashMap<>();
		if (positionPrice1.isEmpty() || positionPrice2.isEmpty() || positionPrice3.isEmpty() || positionPrice4.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		appService.updatePositionPrice(positionPrice1,positionPrice2,positionPrice3,positionPrice4);
		result.put("success", true);
		return result;
	}

	@RequestMapping("/updateSkillPrice")
	public Map<String, Object> updateSkillPrice(@RequestBody Map<String, String> params) {
		String skillPrice1 = params.get("skillPrice1");
		String skillPrice2 = params.get("skillPrice2");
		String skillPrice3 = params.get("skillPrice3");
		String skillPrice4 = params.get("skillPrice4");
		Map<String, Object> result = new HashMap<>();
		if (skillPrice1.isEmpty() || skillPrice2.isEmpty() || skillPrice3.isEmpty() || skillPrice4.isEmpty()) {
			result.put("msg", Constants.Result.CSBNWK);
			return result;
		}
		appService.updateSkillPrice(skillPrice1,skillPrice2,skillPrice3,skillPrice4);
		result.put("success", true);
		return result;
	}

	@RequestMapping("/getSwiper")
	public List<Map<String, Object>> getSwiper() {
		return appService.getAppByType(Constants.AppType.SYLBT);
	}

	@RequestMapping("/getNotice")
	public Map<String, Object> getNotice() {
		return appService.getAppByType(Constants.AppType.XXTZ).get(0);
	}

}
