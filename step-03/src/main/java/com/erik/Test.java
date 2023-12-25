package com.erik;

import com.erik.dao.UserDao;
import com.erik.service.UserService;
import com.spring.PropertyValue;
import com.spring.PropertyValues;
import com.spring.io.config.BeanDefinition;
import com.spring.io.config.BeanReference;
import com.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author fc
 * @date 2023/12/21 16:56
 */
public class Test {
    public static void main(String[] args) {


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);
        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition userPeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registerBeanDefinition("userService", userPeanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();

    }
}
