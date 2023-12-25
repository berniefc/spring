package com.spring.beans.factory.factory;

import com.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author fc
 * @date 2023/12/23 15:58
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

}
