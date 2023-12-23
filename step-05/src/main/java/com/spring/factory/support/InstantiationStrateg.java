package com.spring.factory.support;

import com.spring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;


/**
 * @author fc
 * @date 2023/12/22 11:41
 */
public interface InstantiationStrateg {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);

}
