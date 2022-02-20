package com.graduation.service;

import com.graduation.domain.Evaluate;
import com.graduation.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EvaluateService {

    @Autowired(required = false)
    private EvaluateMapper evaluateMapper;

    public void insertEvaluate(Evaluate evaluate) {
        evaluateMapper.insertEvaluate(evaluate);
    }

    public List<Map<String, Object>> getEvaluateByLimit(String offset, String rows) {
        return evaluateMapper.getEvaluateByLimit(offset,rows);
    }

}
