package com.projekt.ai.api.controller;

import com.projekt.ai.bll.model.user.UserLoginIn;
import com.projekt.ai.bll.model.user.UserLoginOut;
import com.projekt.ai.bll.model.user.UserRegisterIn;
import com.projekt.ai.bll.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody UserRegisterIn userRegisterIn) {
        userService.register(userRegisterIn);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginOut login(@RequestBody UserLoginIn userLoginIn) {
        return userService.login(userLoginIn);
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    public void checkEmail(@RequestParam String email, HttpServletResponse response) {
        userService.checkEmail(email, response);
    }

    @RequestMapping(value = "/checkUsername", method = RequestMethod.GET)
    public void checkUsername(@RequestParam String username, HttpServletResponse response) {
        userService.checkUsername(username, response);
    }
}
