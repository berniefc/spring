package com.erik;

import com.erik.dao.UserDao;
import com.erik.service.UserService;
import com.spring.PropertyValue;
import com.spring.PropertyValues;
import com.spring.factory.config.BeanDefinition;
import com.spring.factory.config.BeanReference;
import com.spring.factory.support.BeanDefinitionRegistry;
import com.spring.factory.support.DefaultListableBeanFactory;
import com.spring.factory.xml.XmlBeanDefinitionReader;

/**
 * @author fc
 * @date 2023/12/21 16:56
 */
public class Test {
    public static void main(String[] args) {
        //初始化工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
