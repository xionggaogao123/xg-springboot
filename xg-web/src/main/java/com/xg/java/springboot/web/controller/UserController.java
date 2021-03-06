package com.xg.java.springboot.web.controller;

import com.xg.java.springboot.common.exception.JsonResponseException;
import com.xg.java.springboot.common.module.Response;
import com.xg.java.springboot.user.api.user.model.User;
import com.xg.java.springboot.user.api.user.service.UserReadService;
import io.terminus.boot.rpc.common.annotation.RpcConsumer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xionggao on 2017/6/27.
 *
 */
@RestController
public class UserController {

    @RpcConsumer
    private UserReadService userReadService;

    @RequestMapping(value = "test")
    public String test() {
        return "hello world";
    }

    @RequestMapping(value = "/user/getUserById",method = RequestMethod.GET)
    public User getUserById(Long id){
        Response<User> userResponse = userReadService.getUserById(id);
        if(!userResponse.isSuccess()){
            throw new JsonResponseException(userResponse.getErrors());
        }
        return userResponse.getResult();
    }
    
    
    
}
