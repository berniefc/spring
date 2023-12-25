package com.spring.beans.factory.support;

import com.spring.io.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fc
 * @date 2023/12/22 9:43
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
