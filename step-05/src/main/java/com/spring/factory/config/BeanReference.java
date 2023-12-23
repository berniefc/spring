package com.spring.factory.config;

/**
 * @author fc
 * @date 2023/12/22 15:43
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
