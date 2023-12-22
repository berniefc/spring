package com.spring.factory;

import com.spring.BeanException;

/**
 * @author fc
 * @date 2023/12/21 17:35
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeanException;

    Object getBean(String name, Object... args) throws BeanException;

}
