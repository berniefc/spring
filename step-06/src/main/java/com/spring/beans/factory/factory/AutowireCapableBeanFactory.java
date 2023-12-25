package com.spring.beans.factory.factory;

import com.spring.beans.BeanException;
import com.spring.beans.factory.BeanFactory;

/**
 * @author fc
 * @date 2023/12/25 14:56
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(String beanName, Object bean) throws BeanException;

    Object applyBeanPostProcessorsAfterInitialization(String beanName, Object bean) throws BeanException;

}
