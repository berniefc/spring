package com.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fc
 * @date 2023/12/21 17:00
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 根据bean名称获取对应的bean对象
     * @param beanName bean的名称
     * @return 匹配的bean对象
     */
    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }


    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){
        // 将beanName和beanDefinition映射关系存储在beanDefinitionMap中
        beanDefinitionMap.put(beanName, beanDefinition);
    }


}
