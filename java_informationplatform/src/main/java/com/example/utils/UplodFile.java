package com.example.utils;

import com.aliyun.oss.OSSClient;
import com.example.cooperation.pojo.GatheringPayment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class UplodFile {


    private static String bucket;
    private static String ossAccessId;  // 你的访问AK信息
    private static String ossAccessKey; // 你的访问AK信息
    private static String ossEndpoint;  // 如: http://oss-cn-beijing.aliyuncs.com
    static {
        bucket = "dytz";
        ossAccessId = "LTAI5onE2cPusoWT";
        ossAccessKey = "yPE3D3IbIhQ4JwcGNdz0ON5rLU4Z9P";
        ossEndpoint = "oss-cn-beijing.aliyuncs.com";
    }


    OSSClient ossClient = new OSSClient(ossEndpoint, ossAccessId, ossAccessKey);
    public String uplodFile(MultipartFile fileImg) {

        // String inputStream = service_accessory.getOriginalFilename();
        String substring = fileImg.getOriginalFilename().substring(fileImg.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + substring;
        String key = "elevatorinvoice/" + fileName;
        InputStream inputStream = null;
        try {
            inputStream = fileImg.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传有问题");
        }
        ossClient.putObject(bucket, key, inputStream);
        String str = "https://" + bucket + "." + ossEndpoint + "/" + "elevatorinvoice" + "/" + fileName;

        return str;
    }
    public String uplodFileImg(MultipartFile fileImg) {

        // String inputStream = service_accessory.getOriginalFilename();
        String substring = fileImg.getOriginalFilename().substring(fileImg.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + substring;
        String key = "elevatorinstallsell/" + fileName;
        InputStream inputStream = null;
        try {
            inputStream = fileImg.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传有问题");
        }
        ossClient.putObject(bucket, key, inputStream);
        String str = "https://" + bucket + "." + ossEndpoint + "/" + "elevatorinvoice" + "/" + fileName;

        return str;
    }
}
