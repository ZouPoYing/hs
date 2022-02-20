package com.graduation.domain;

public class Evaluate {

    private Integer evaluateId;

    private String level;

    private String img;

    private String message;

    public Evaluate(Integer evaluateId, String level, String img, String message) {
        this.evaluateId = evaluateId;
        this.level = level;
        this.img = img;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluateId=" + evaluateId +
                ", level='" + level + '\'' +
                ", img='" + img + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
