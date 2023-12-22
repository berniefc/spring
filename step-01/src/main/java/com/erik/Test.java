package com.erik;

import com.erik.service.UserService;
import com.spring.BeanDefinition;
import com.spring.BeanFactory;

/**
 * @author fc
 * @date 2023/12/21 16:56
 */
public class Test {
    public static void main(String[] args) {
        // 创建 BeanFactory
        BeanFactory factory = new BeanFactory();

        //注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        factory.registerBeanDefinition("userService", beanDefinition);

        //获取bean
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }


}
