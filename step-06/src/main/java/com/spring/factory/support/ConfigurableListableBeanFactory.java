package com.spring.factory.support;

import com.spring.BeanException;
import com.spring.factory.BeanFactory;

/**
 * @author fc
 * @date 2023/12/23 16:01
 */
public class ConfigurableListableBeanFactory implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeanException {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) throws BeanException {
        return null;
    }
}
