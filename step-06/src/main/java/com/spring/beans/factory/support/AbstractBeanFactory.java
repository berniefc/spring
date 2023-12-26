package com.spring.beans.factory.support;

import com.spring.beans.BeanException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.factory.BeanDefinition;
import com.spring.beans.factory.factory.BeanPostProcessor;
import com.spring.beans.factory.factory.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fc
 * @date 2023/12/22 9:54
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    @Override
    public Object getBean(String beanName) throws BeanException {

        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeanException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeanException {
        return (T)getBean(beanName);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeanException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
