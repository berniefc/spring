package com.erik.service;

import com.erik.dao.UserDao;

/**
 * @author fc
 * @date 2023/12/21 16:55
 */
public class UserService {

    private String uId;

    private String name;

    private String company;

    private UserDao userDao;

    public UserService(){

    }

    public UserService(String name){
        this.name = name;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void test(){
        System.out.println("userService-----test");
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息:"+userDao.queryUserName(uId)+","+company+","+name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
