package com.spring.factory.support;

import com.spring.factory.config.BeanDefinition;
import com.spring.BeanException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fc
 * @date 2023/12/22 10:46
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeanException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }
}
