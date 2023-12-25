package com.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.BeanException;
import com.spring.PropertyValue;
import com.spring.PropertyValues;
import com.spring.io.config.BeanDefinition;
import com.spring.io.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author fc
 * @date 2023/12/22 10:07
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

//    private InstantiationStrateg instantiationStrateg = new CglibSubclassingInstantiationStrategy();

    private InstantiationStrateg instantiationStrateg = new SimpleInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            addPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeanException("创建bean实例失败", e);
        }
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

    protected void addPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeanException e) {
            throw new BeanException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrateg getInstantiationStrateg() {
        return instantiationStrateg;
    }

    public void setInstantiationStrateg(InstantiationStrateg instantiationStrateg) {
        this.instantiationStrateg = instantiationStrateg;
    }

}
