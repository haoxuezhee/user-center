package com.hxt.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxt.usercenter.bean.User;

import javax.servlet.http.HttpServletRequest;


/**
* @author 86185
* @description 针对表【user】的数据库操作Service
* @createDate 2024-09-01 18:27:29
*/
public interface UserService extends IService<User> {


    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 用户id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    /**
     * 用户登陆
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request 用户请求
     * @return 用户信息
     */

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 信息脱敏
     * @param originalUser
     * @return
     */
    User getSafetyUser(User originalUser);

    /**
     * 退出登录,用户注销
     * @return
     */
    int UserLoginOut(HttpServletRequest request);
}
