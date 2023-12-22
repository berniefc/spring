package com.spring.factory.support;

import com.spring.factory.config.BeanDefinition;
import com.spring.BeanException;
import com.spring.factory.BeanFactory;

/**
 * @author fc
 * @date 2023/12/22 9:54
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeanException{
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;

}
