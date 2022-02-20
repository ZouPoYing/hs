package com.graduation.domain;

public class User {
    private Integer userId;

    private String nickName;

    private String userType;
    
    private String phoneNumber;
    
    private String avatarUrl;

    private String sex;

    private String year;

    private String hair;

    private String face;

    private String job;

    private String education;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", userType='" + userType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", sex='" + sex + '\'' +
                ", year='" + year + '\'' +
                ", hair='" + hair + '\'' +
                ", face='" + face + '\'' +
                ", job='" + job + '\'' +
                ", education='" + education + '\'' +
                '}';
    }

    public User(Integer userId, String nickName, String userType, String phoneNumber, String avatarUrl, String sex, String year, String hair, String face, String job, String education) {
        this.userId = userId;
        this.nickName = nickName;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.avatarUrl = avatarUrl;
        this.sex = sex;
        this.year = year;
        this.hair = hair;
        this.face = face;
        this.job = job;
        this.education = education;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public User(Integer userId, String nickName, String userType, String phoneNumber, String avatarUrl) {
        this.userId = userId;
        this.nickName = nickName;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
        this.avatarUrl = avatarUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}