package com.erik.common;

import com.spring.beans.PropertyValue;
import com.spring.beans.PropertyValues;
import com.spring.beans.factory.ConfigurableListableBeanFactory;
import com.spring.beans.factory.factory.BeanDefinition;
import com.spring.beans.factory.factory.BeanFactoryPostProcessor;

/**
 * @author fc
 * @date 2023/12/26 15:15
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
