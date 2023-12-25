package com.spring.beans.factory.support;

import com.spring.io.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author fc
 * @date 2023/12/22 13:58
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrateg{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp(){
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null==ctor) return enhancer.create();

        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
