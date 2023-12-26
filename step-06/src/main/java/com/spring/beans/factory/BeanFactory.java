package com.spring.beans.factory;

import com.spring.beans.BeanException;

/**
 * @author fc
 * @date 2023/12/21 17:35
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

    <T> T getBean(String beanName,Class<T> requiredType) throws BeanException;

}
