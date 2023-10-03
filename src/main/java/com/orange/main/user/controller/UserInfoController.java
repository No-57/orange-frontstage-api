package com.orange.main.user.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.main.user.bo.UserInfo;
import com.orange.main.user.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    
    private UserInfoService userInfoService;

    @GetMapping("/allusers")
    public Collection<UserInfo> users() {
        
        Iterable<UserInfo> customer = userInfoService.getAllUsers();
        Collection<UserInfo> rt = new ArrayList<>();
        customer.forEach(rt::add);
        return rt;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        UserInfo user = userInfoService.getUserById(id);
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    
}


