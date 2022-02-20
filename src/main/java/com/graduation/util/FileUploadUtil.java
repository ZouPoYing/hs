package com.graduation.util;

import com.graduation.bean.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtil {

    /**
     * 上传文件
     *
     * @param multipartFile
     * @return 文件存储路径
     */
    public static String upload(MultipartFile multipartFile, String userId, String fileType) throws Exception {
        // 文件存储位置，文件的目录要存在才行，可以先创建文件目录，然后进行存储
        String filename = userId + "_" + System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename() + "." + fileType;
        String filePath = Constants.File.PATH + filename;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 文件存储
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
