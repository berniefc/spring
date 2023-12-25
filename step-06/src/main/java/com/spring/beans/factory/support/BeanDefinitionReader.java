package com.spring.beans.factory.support;

import com.spring.beans.BeanException;
import com.spring.io.Resource;
import com.spring.io.ResourceLoader;

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
