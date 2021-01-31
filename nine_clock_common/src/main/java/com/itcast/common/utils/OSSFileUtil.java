package com.itcast.common.utils;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class OSSFileUtil {

    private final String ossBucket;
    private final String baseDir;
    private final OSSClient ossClient;

    private static final DateFormat fileNameFormatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public OSSFileUtil(String endpoint, String ossBucket, String baseDir, String key, String secret) throws IOException {
        this.ossBucket = ossBucket.trim();
        this.baseDir = baseDir.trim();
        this.ossClient = new OSSClient(endpoint.trim(), key.trim(), secret.trim());
    }

    public String generateFilePath(File file) {
        String randomFileName = fileNameFormatter.format(new Date()) + "-" + file.getName();
        return Paths.get(
                baseDir,
                randomFileName
        ).toString();
    }

    //直接通过request
    public String saveFile(HttpServletRequest httpServletRequest) throws Exception {
        String path = "";
        if (httpServletRequest instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) httpServletRequest;
            MultipartFile multipartFile = mrequest.getFile("file");
            InputStream ins = multipartFile.getInputStream();
            path = this.saveFile(ins, multipartFile.getOriginalFilename());
            ins.close();
        }
        return path;
    }

    public String saveImage(InputStream inputStream, String objName) throws IOException {
        String randomFileName = fileNameFormatter.format(new Date()) + "-" + objName;
        String path = Paths.get(
                randomFileName
        ).toString();
        // 上传文件流。
        ossClient.putObject(ossBucket, path, inputStream);
        return path;
    }

    public String saveFile(InputStream inputStream, String objName) throws IOException {
        String randomFileName = fileNameFormatter.format(new Date()) + "-" + objName;
        String path = Paths.get(
                baseDir,
                randomFileName
        ).toString();
        // 上传文件流。
        PutObjectResult putObjectResult = ossClient.putObject(ossBucket, path, inputStream);
        log.info("上传文件：{}",randomFileName+"，结果："+putObjectResult.toString());
        return path;
    }

    public String saveFile(File file) throws IOException {
        String path = generateFilePath(file);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(Files.probeContentType(file.toPath()));
        metadata.setContentLength(file.length());
        metadata.setHeader("x-oss-server-side-encryption", "AES256");
        ossClient.putObject(ossBucket, path, file, metadata);
        return path;
    }

    public boolean deleteFile(String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            return true;
        }
        try {
            ossClient.deleteObject(ossBucket, filePath);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IOException("", e);
        }
    }

    public InputStream openStream(String filePath) throws IOException {
        return ossClient.getObject(ossBucket, filePath).getObjectContent();
    }

}
