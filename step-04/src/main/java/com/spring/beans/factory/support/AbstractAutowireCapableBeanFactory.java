package com.spring.beans.factory.support;

import com.spring.BeanException;
import com.spring.io.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author fc
 * @date 2023/12/22 10:07
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrateg instantiationStrateg = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeanException {
        Object bean = null;
        bean = createBeanInstance(beanName, beanDefinition, args);

        if (bean != null) {
            addSingleton(beanName, bean);
        }
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object... args) {
        Constructor ctor = null;

        Class<?> beanClass = beanDefinition.getBeanClass();

        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                ctor = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrateg().instantiate(beanDefinition, beanName, ctor, args);
    }

    public InstantiationStrateg getInstantiationStrateg() {
        return instantiationStrateg;
    }

    public void setInstantiationStrateg(InstantiationStrateg instantiationStrateg) {
        this.instantiationStrateg = instantiationStrateg;
    }

}
