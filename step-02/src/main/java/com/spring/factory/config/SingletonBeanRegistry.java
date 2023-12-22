package com.spring.factory.config;

/**
 * @author fc
 * @date 2023/12/22 9:42
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);


}
