package com.graduation.service;

import com.graduation.domain.File;
import com.graduation.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired(required = false)
    private FileMapper fileMapper;

    public void fileUpload(String fileName, Integer userId) throws Exception {
        fileMapper.fileUpload(fileName,userId);
    }

    public File getFileByFileName(String fileName) throws Exception {
        return fileMapper.getFileByFileName(fileName);
    }

    public File getFileByFileId(Integer fileId) throws Exception {
        return fileMapper.getFileByFileId(fileId);
    }
}
