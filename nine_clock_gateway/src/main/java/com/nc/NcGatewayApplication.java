package com.nc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.nc
 * @author: 戈向峰
 * @description: 网关服务启动器
 * @createTime: 2021-01-24 15:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NcGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(NcGatewayApplication.class,args);
    }
}
