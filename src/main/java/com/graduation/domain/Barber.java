package com.graduation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Barber {

    private Integer barberId;

    private String barberName;

    private String barberHead;

    private String barberBack;

    private String skill;

    private String starTime;

    private String endTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String entryTime;

    private String isWork;

    private String skillDescribe;

    public Barber(Integer barberId, String barberName, String barberHead, String barberBack, String skill, String starTime, String endTime, String entryTime, String isWork, String skillDescribe) {
        this.barberId = barberId;
        this.barberName = barberName;
        this.barberHead = barberHead;
        this.barberBack = barberBack;
        this.skill = skill;
        this.starTime = starTime;
        this.endTime = endTime;
        this.entryTime = entryTime;
        this.isWork = isWork;
        this.skillDescribe = skillDescribe;
    }

    public Integer getBarberId() {
        return barberId;
    }

    public void setBarberId(Integer barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public String getBarberHead() {
        return barberHead;
    }

    public void setBarberHead(String barberHead) {
        this.barberHead = barberHead;
    }

    public String getBarberBack() {
        return barberBack;
    }

    public void setBarberBack(String barberBack) {
        this.barberBack = barberBack;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getStarTime() {
        return starTime;
    }

    public void setStarTime(String starTime) {
        this.starTime = starTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    @Override
    public String toString() {
        return "Barber{" +
                "barberId=" + barberId +
                ", barberName='" + barberName + '\'' +
                ", barberHead='" + barberHead + '\'' +
                ", barberBack='" + barberBack + '\'' +
                ", skill='" + skill + '\'' +
                ", starTime='" + starTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", isWork='" + isWork + '\'' +
                ", skillDescribe='" + skillDescribe + '\'' +
                '}';
    }
}
