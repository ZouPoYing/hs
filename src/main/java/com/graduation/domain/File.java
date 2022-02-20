package com.graduation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class File {

    private Integer fileId;

    private String fileName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    private Integer userId;

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }

    public File(Integer fileId, String fileName, Date date, Integer userId) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.date = date;
        this.userId = userId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
