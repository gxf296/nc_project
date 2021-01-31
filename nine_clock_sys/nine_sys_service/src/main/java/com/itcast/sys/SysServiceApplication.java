package com.itcast.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.sys
 * @author: 戈向峰
 * @description: 系统服务启动类
 * @createTime: 2021-01-30 16:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SysServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysServiceApplication.class);
    }
}
