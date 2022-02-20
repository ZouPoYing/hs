package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.service.AppService;
import com.graduation.service.BarberService;
import com.graduation.service.FileService;
import com.graduation.service.OrderService;
import com.graduation.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.graduation.bean.Constants.File.URL;

@RestController
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/barber")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AppService appService;

    @Autowired
    private OrderService orderService;

    // 获取理发师数据
    @RequestMapping("/getBarbers")
    public List<Map<String, Object>> getBarbers() {
        return barberService.getBarbers();
    }

    // 获取理发师数据
    @RequestMapping("/getBarberByBarberId")
    public Map<String, Object> getBarberByBarberId(@RequestBody Map<String, String> params) throws Exception {
        String barberId = params.get("barberId");
        Map<String, Object> result = new HashMap<>();
        if (barberId.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        result = barberService.getBarberByBarberId(barberId);
        int head = fileService.getFileByFileName(result.get("barber_head").toString().replace(URL,"")).getFileId();
        int back = fileService.getFileByFileName(result.get("barber_back").toString().replace(URL,"")).getFileId();
        result.put("head", head);
        result.put("back", back);
        result.put("success", true);
        return result;
    }

    // 修改或新增理发师
    @RequestMapping("/insertBarber")
    public Map<String, Object> insertBarber(@RequestBody Map<String, String> params) throws Exception {
        String head = params.get("head");
        String back = params.get("back");
        String barberName = params.get("barberName");
        String skill = params.get("skill");
        String starTime = params.get("starTime");
        String endTime = params.get("endTime");
        String isWork = params.get("isWork");
        String position = params.get("position");
        String describe = params.get("describe");
        String isMod = params.get("isMod");
        String barberId = params.get("barberId");
        Map<String, Object> result = new HashMap<>();
        if (isMod.isEmpty() || head.isEmpty() || back.isEmpty() || barberName.isEmpty() || skill.isEmpty() || starTime.isEmpty() || endTime.isEmpty() || isWork.isEmpty() || position.isEmpty() || describe.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        String headUrl = URL + fileService.getFileByFileId(Integer.parseInt(head)).getFileName();
        String backUrl = URL + fileService.getFileByFileId(Integer.parseInt(back)).getFileName();
        if (isMod == "true") {
            barberService.updateBarberByBarberId(barberId,headUrl,backUrl,barberName,skill,starTime,endTime,isWork,position,describe);
        } else {
            barberService.insertBarber(headUrl,backUrl,barberName,skill,starTime,endTime,isWork,position,describe);
        }
        result.put("success", true);
        return result;
    }

    // 删除理发师数据
    @RequestMapping("/deleteBarberByBarberId")
    public Map<String, Object> deleteBarberByBarberId(@RequestBody Map<String, String> params) {
        String barberId = params.get("barberId");
        Map<String, Object> result = new HashMap<>();
        if (barberId.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        barberService.deleteBarberByBarberId(barberId);
        result.put("success", true);
        return result;
    }

    // 自动匹配理发师数据
    @RequestMapping("/matchBarberBySkill")
    public List<Map<String, Object>> matchBarberBySkill(@RequestBody Map<String, String> params) {
        String skill = params.get("skill");
        List<Map<String, Object>> barbers = barberService.getWorkBarbers(MyUtil.matchSub(skill));
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> barber : barbers ) {
            String skillPrice = appService.getPriceById(MyUtil.matchAppId(barber.get("skill")));
            String positionPrice = appService.getPriceById(MyUtil.matchAppId(barber.get("position")));
            int line = orderService.getOrderCountByBarberIdAndStatusSub(barber.get("barber_id").toString(),Constants.StatusSub.LFSYDDZZJXZ);
            BigDecimal sPrice = new BigDecimal(skillPrice);
            BigDecimal pPrice = new BigDecimal(positionPrice);
            barber.put("skillPrice", skillPrice);
            barber.put("positionPrice", positionPrice);
            barber.put("price", sPrice.add(pPrice));
            barber.put("line", line);
            result.add(barber);
        }
        return result;
    }

}
