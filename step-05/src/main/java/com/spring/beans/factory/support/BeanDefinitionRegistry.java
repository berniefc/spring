package com.spring.beans.factory.support;

import com.spring.io.config.BeanDefinition;

/**
 * @author fc
 * @date 2023/12/22 10:54
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

}
