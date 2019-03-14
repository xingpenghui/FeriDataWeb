package com.feri.feridataweb.controller;

import com.feri.feridataweb.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/3/13 09:47
 */
@Api(value = "用户",tags = "用户相关操作")
@RestController
public class UserController {

    //查询用户
    @ApiOperation(value = "全部用户",notes = "查询全部的用户信息")
    @GetMapping("userall.do")
    public String all(){
        return "暂无数据";
    }
    @ApiOperation(value = "登录",notes = "实现用户的登录，记得自己验空")
    @GetMapping("userlogin.do")
    public String login(@ApiParam(name = "name",value = "用户名") String name){
        return name+"成功";
    }
    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping("usersave.do")
    public String save(@RequestBody User user)
    {
        System.out.println(user.getName());
        return "OK";
    }

}
