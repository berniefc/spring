package com.spring.context.support;

import com.spring.beans.BeanException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.ConfigurableListableBeanFactory;
import com.spring.context.ConfigurableApplicationContext;
import com.spring.io.DefaultResourceLoader;

/**
 * @author fc
 * @date 2023/12/25 14:49
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeanException {

        refreshBeanFactory();

        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        invokeBeanFactoryPostProcessors(beanFactory);

        registerBeanPostProcessors(beanFactory);

        beanFactory.preInstantiateSingletons();
    }


    protected abstract void refreshBeanFactory() throws BeanException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

   private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){

   };

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {

    }

}
