package com.spring.context;

import com.spring.beans.BeanException;

/**
 * @author fc
 * @date 2023/12/25 14:41
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    void refresh() throws BeanException;

}
