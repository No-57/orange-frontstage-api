package com.orange.main.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.main.user.bo.UserInfo;
import com.orange.main.user.repo.UserInfoRepository;
import com.orange.main.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

   
    @Override
    public UserInfo createUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserInfo getUserById(Long userId) {
        Optional<UserInfo> optionalUser = userInfoRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public Iterable<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        Optional<UserInfo> u = userInfoRepository.findById(userInfo.getUserId());
        u.get().setUserAccNo(userInfo.getUserAccNo());
        u.get().setUserPd(userInfo.getUserPd());
        userInfoRepository.save(u.get());
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(Long userId) {
        userInfoRepository.deleteById(userId);
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

     public UserInfoRepository getUserInfoRepository() {
        return userInfoRepository;
    }

    public void setUserInfoRepository(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

}
