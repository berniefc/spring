package com.erik.common;

import com.erik.service.UserService;
import com.spring.beans.BeanException;
import com.spring.beans.factory.factory.BeanPostProcessor;

/**
 * @author fc
 * @date 2023/12/26 15:18
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) throws BeanException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setName("改为：erik");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) throws BeanException {
        return bean;
    }
}
