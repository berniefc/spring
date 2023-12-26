package com.erik;

import com.erik.service.UserService;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.context.support.ClassPathXmlApplicationContext;

/**
 * @author fc
 * @date 2023/12/21 16:56
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.queryUserInfo();

    }
}
