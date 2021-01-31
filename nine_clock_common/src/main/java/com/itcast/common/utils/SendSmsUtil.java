package com.itcast.common.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/*
pom.xml
<dependency>
  <groupType>com.aliyun</groupType>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
@Slf4j
public class SendSmsUtil {

    private final String key;
    private final String secret;
    private final String signName;
    //private final String templateCode;

    public SendSmsUtil(String key, String secret, String signName) {
        this.key = key;
        this.secret = secret;
        this.signName = signName;
    }

    //九点钟移动办公 "SMS_173696218" "{'code':7777}"
    public void sendMessage(String phoneNumber, String templateCode, String templateParam) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", key, secret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", templateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            Map<String, String> map = JsonUtils.toMap(response.getData(), String.class, String.class);
            if (!"OK".equals(map.get("Code"))) {
                log.error("用户微服务-发送短信失败：{}", response.getData());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

}
