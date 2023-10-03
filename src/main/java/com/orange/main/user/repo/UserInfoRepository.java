package com.orange.main.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.orange.main.user.bo.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{
    
}

