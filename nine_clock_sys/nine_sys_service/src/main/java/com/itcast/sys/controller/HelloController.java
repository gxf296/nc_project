package com.itcast.sys.controller;

import com.itcast.common.enums.ResponseEnum;
import com.itcast.common.exception.NcException;
import com.itcast.common.vo.ExceptionResultInfo;
import com.itcast.sys.pojo.User;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0.0
 * @belongsProject: nine_clock_project
 * @belongsPackage: com.itcast.sys.controller
 * @author: 戈向峰
 * @description: 测试异常类
 * @createTime: 2021-01-30 17:50
 */
@RestController
public class HelloController {
    @GetMapping("/test")
    public ExceptionResultInfo test() {
        return new ExceptionResultInfo(true, 200, "操作成功", "hello");
    }

    @PostMapping("/addUser")
    public ExceptionResultInfo test1(@RequestBody User user){
        user.setId(18);
        if (user.getAge().isEmpty()){
           throw new NcException(ResponseEnum.ERROR);
        }
        return ExceptionResultInfo.success("用户保存信息成功",user);
    }
}
