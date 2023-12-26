package com.spring.context.support;

import com.spring.beans.BeanException;
import com.spring.beans.factory.support.DefaultListableBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author fc
 * @date 2023/12/26 14:46
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext(){

    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeanException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeanException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
