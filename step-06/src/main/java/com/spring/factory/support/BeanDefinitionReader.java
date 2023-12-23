package com.spring.factory.support;

import com.spring.BeanException;
import com.spring.factory.io.Resource;
import com.spring.factory.io.ResourceLoader;

/**
 * @author fc
 * @date 2023/12/23 11:02
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;

}
