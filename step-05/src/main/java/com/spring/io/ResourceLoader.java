package com.spring.io;

/**
 * @author fc
 * @date 2023/12/23 10:53
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
