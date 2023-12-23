package com.spring.factory.config;

import com.spring.factory.support.ConfigurableListableBeanFactory;

/**
 * @author fc
 * @date 2023/12/23 15:58
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

}
