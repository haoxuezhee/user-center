package com.hxt.usercenter;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxt.usercenter.bean.User;
import com.hxt.usercenter.mapper.UserMapper;
import com.hxt.usercenter.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class UserCenterApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User user = userMapper.selectById(1L);
        System.out.println(user);
    }


    @Test
    void testAddUser(){

        User user = new User();
        user.setUsername("lisi");
        user.setUserAccount("123");
        user.setAvatarUrl("xxx");
        user.setGender(0);
        user.setUserPassword("111111");
        user.setPhone("14312321232");
        user.setEmail("222@qq.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setPlanetCode("8796");
        user.setTags("bbb");
        boolean save = userService.save(user);
        System.out.println(user.getId()+":"+save);
    }


    @Test
    void testMd5(){
        final String SALT="HTH";
        String s = DigestUtils.md5DigestAsHex((SALT + "userPasswprd").getBytes());
        System.out.println(s);
    }

    @Test
    void userRegister(){
        String userAccount="hxt1";
        String userPassword="";
        String checkPassword="12345678";
       // long register = userService.userRegister(userAccount, userPassword, checkPassword);
       // Assertions.assertEquals(-1,register);


        userAccount="wangwu";
        userPassword="12345678";
        checkPassword="12345678";
       // register = userService.userRegister(userAccount, userPassword, checkPassword);
       // Assertions.assertTrue(register>0);



    }


    @Test
    void test02(){
        final String SALT="HTH";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + "12345678").getBytes());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userPassword",encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);

    }

}
