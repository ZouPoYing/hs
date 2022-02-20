package com.graduation.mapper;

import com.graduation.domain.File;
import org.apache.ibatis.annotations.*;



@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILE(FILE_NAME, USER_ID) VALUES (#{fileName}, #{userId})")
    void fileUpload(String fileName, Integer userId);

    @Select("SELECT * FROM FILE WHERE FILE_NAME=#{fileName}")
    File getFileByFileName(String fileName);

    @Select("SELECT * FROM FILE WHERE FILE_ID=#{fileId}")
    File getFileByFileId(Integer fileId);
}
