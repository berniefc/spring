package com.spring.beans.factory.factory;

import com.spring.beans.BeanException;

/**
 * @author fc
 * @date 2023/12/23 16:02
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(String beanName, Object bean) throws BeanException;

    Object postProcessAfterInitialization(String beanName, Object bean) throws BeanException;

}
