package com.spring.beans.factory;

import com.spring.beans.BeanException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.factory.AutowireCapableBeanFactory;
import com.spring.beans.factory.factory.ConfigurableBeanFactory;

/**
 * @author fc
 * @date 2023/12/23 16:01
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    void preInstantiateSingletons() throws BeanException;

}
