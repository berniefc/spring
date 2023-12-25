package com.spring.beans.factory;

import com.spring.beans.BeanException;

import java.util.Map;

/**
 * @author fc
 * @date 2023/12/25 14:32
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException;

    String[] getBeanDefinitionNames();

}
