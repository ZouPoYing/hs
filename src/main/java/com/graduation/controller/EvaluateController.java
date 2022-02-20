package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.domain.Evaluate;
import com.graduation.service.EvaluateService;
import com.graduation.service.FileService;
import com.graduation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.graduation.bean.Constants.File.URL;

@RestController
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private FileService fileService;

    @Autowired
    private OrderService orderService;

    // 评价
    @RequestMapping("/evaluate")
    public Map<String, Object> evaluate(@RequestBody Map<String, String> params) throws Exception {
        String orderId = params.get("orderId");
        String level = params.get("level");
        String img = params.get("img");
        String message = params.get("message");
        Map<String, Object> result = new HashMap<>();
        if (orderId.isEmpty() || level.isEmpty() || img.isEmpty() || message.isEmpty()) {
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        String imgUrl = URL + fileService.getFileByFileId(Integer.parseInt(img)).getFileName();
        Evaluate evaluate = new Evaluate(null,level,imgUrl,message);
        evaluateService.insertEvaluate(evaluate);
        orderService.setEvaluate(orderId,evaluate.getEvaluateId(),Constants.StatusType.WC);
        result.put("success", true);
        return result;
    }

    // 获取评价
    @RequestMapping("/getEvaluate")
    public List<Map<String, Object>> getEvaluate(@RequestBody Map<String, String> params) throws Exception {
        String offset = params.get("offset");
        String rows = params.get("rows");
        if (offset.isEmpty() || rows.isEmpty()) {
            return null;
        }
        List<Map<String, Object>> result = evaluateService.getEvaluateByLimit(offset,rows);
        return result;
    }
}
