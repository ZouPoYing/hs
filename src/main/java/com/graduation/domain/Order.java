package com.graduation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {

    private Integer orderId;

    private Integer userId;

    private Integer barberId;

    private Integer evaluateId;

    private String status;

    private String price;

    private String orderType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payTime;

    public Order(Integer orderId, Integer userId, Integer barberId, Integer evaluateId, String status, String price, String orderType, Date startTime, Date endTime, Date payTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.barberId = barberId;
        this.evaluateId = evaluateId;
        this.status = status;
        this.price = price;
        this.orderType = orderType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", barberId=" + barberId +
                ", evaluateId=" + evaluateId +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", orderType='" + orderType + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", payTime=" + payTime +
                '}';
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Order(Integer orderId, Integer userId, Integer barberId, Integer evaluateId, String status, String price, String orderType, Date startTime, Date endTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.barberId = barberId;
        this.evaluateId = evaluateId;
        this.status = status;
        this.price = price;
        this.orderType = orderType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBarberId() {
        return barberId;
    }

    public void setBarberId(Integer barberId) {
        this.barberId = barberId;
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
