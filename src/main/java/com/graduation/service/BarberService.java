package com.graduation.service;

import com.graduation.mapper.BarberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BarberService {

    @Autowired(required = false)
    private BarberMapper mapper;

    public List<Map<String, Object>> getBarbers() {
        return mapper.getBarbers();
    }

    public Map<String, Object> getBarberByBarberId(String barberId) {
        return mapper.getBarberByBarberId(barberId);
    }

    public void insertBarber(String barberHead,String barberBack,String barberName,String skill,String starTime,String endTime,String isWork,String position,String describe) {
        mapper.insertBarber(barberHead,barberBack,barberName,skill,starTime,endTime,isWork,position,describe);
    }

    public void deleteBarberByBarberId(String barberId) {
        mapper.deleteBarberByBarberId(barberId);
    }

    public void updateBarberByBarberId(String barberId,String barberHead,String barberBack,String barberName,String skill,String starTime,String endTime,String isWork,String position,String describe) {
        mapper.updateBarberByBarberId(barberId,barberHead,barberBack,barberName,skill,starTime,endTime,isWork,position,describe);
    }

    public List<Map<String, Object>> getWorkBarbers(String sub) {
        return mapper.getWorkBarbers(sub);
    }
}
