package com.spring;

/**
 * @author fc
 * @date 2023/12/21 16:59
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
