package com.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.beans.BeanException;
import com.spring.beans.PropertyValue;
import com.spring.beans.PropertyValues;
import com.spring.beans.factory.factory.AutowireCapableBeanFactory;
import com.spring.beans.factory.factory.BeanDefinition;
import com.spring.beans.factory.factory.BeanPostProcessor;
import com.spring.beans.factory.factory.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author fc
 * @date 2023/12/22 10:07
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrateg instantiationStrateg = new CglibSubclassingInstantiationStrategy();

//    private InstantiationStrateg instantiationStrateg = new SimpleInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeanException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            //给bean填充属性
            addPropertyValues(beanName, bean, beanDefinition);
            //执行beanPostProcessor方法
            bean = initializeBean(beanName, bean, beanDefinition);
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

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(beanName, bean);

        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        wrappedBean = applyBeanPostProcessorsAfterInitialization(beanName, bean);

        return wrappedBean;

    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(String beanName, Object bean) throws BeanException {
        Object result = bean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object currentBean = beanPostProcessor.postProcessBeforeInitialization(beanName, bean);

            if (currentBean == null) {
                return result;
            }
            result = currentBean;
        }
        
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(String beanName, Object bean) throws BeanException {
        Object result = bean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object currentBean = beanPostProcessor.postProcessAfterInitialization(beanName, bean);

            if (currentBean == null) {
                return result;
            }
            result = currentBean;
        }

        return result;
    }
}
