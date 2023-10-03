package com.orange.main.user.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userAccNo;
    private String userPd;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserAccNo() {
        return userAccNo;
    }
    public void setUserAccNo(String userAccNo) {
        this.userAccNo = userAccNo;
    }
    public String getUserPd() {
        return userPd;
    }
    public void setUserPd(String userPd) {
        this.userPd = userPd;
    }
    

}


