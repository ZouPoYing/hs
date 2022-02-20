package com.graduation.controller;

import com.graduation.bean.Constants;
import com.graduation.service.FileService;
import com.graduation.util.BASE64DecodedMultipartFile;
import com.graduation.util.FileDownLoad;
import com.graduation.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials ="true")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/upload")
    public Map<String, Object> upload(@RequestBody Map<String, String> params) throws Exception {
        String file = params.get("file");
        String userId = params.get("userId");
        String fileType = params.get("fileType");
        Map<String, Object> result = new HashMap<>();
        if(userId.isEmpty() || file.isEmpty() || fileType.isEmpty()){
            result.put("msg", Constants.Result.CSBNWK);
            return result;
        }
        MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(file);
        String fileName = FileUploadUtil.upload(multipartFile,userId,fileType);
        fileService.fileUpload(fileName,Integer.valueOf(userId));
        result.put("success", true);
        result.put("fileId", fileService.getFileByFileName(fileName).getFileId().toString());
        return result;
    }

    @GetMapping("/downloadFile/{fileName}")
    public void downloadFile(@PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        //1.获取文件绝对路径
        String path = Constants.File.PATH + fileName;
        //2.通过绝对路径定义File
        File f = new File(path);
        //3.调用FileUtil下载文件
        FileDownLoad.downloadFile(request,response,f,false);
    }
}
