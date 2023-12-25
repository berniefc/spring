package com.spring.beans.factory.factory;

import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.HierarchicalBeanFactory;

/**
 * @author fc
 * @date 2023/12/25 14:57
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
