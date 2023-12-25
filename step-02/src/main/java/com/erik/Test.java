package com.erik;

import com.erik.service.UserService;
import com.spring.io.config.BeanDefinition;
import com.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author fc
 * @date 2023/12/21 16:56
 */
public class Test {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService);

        UserService userService1 = (UserService) factory.getBean("userService");
        System.out.println(userService1);


    }
}
