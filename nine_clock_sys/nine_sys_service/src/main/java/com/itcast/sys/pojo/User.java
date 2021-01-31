package com.itcast.sys.pojo;

import io.micrometer.core.lang.NonNullApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.sys.pojo
 * @author: 戈向峰
 * @description: 模拟用户
 * @createTime: 2021-01-30 18:03
 */
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String age;

    public User(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
