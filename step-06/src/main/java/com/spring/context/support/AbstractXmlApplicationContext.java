package com.spring.context.support;

import com.spring.beans.BeanException;
import com.spring.beans.factory.ConfigurableListableBeanFactory;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author fc
 * @date 2023/12/26 14:46
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
