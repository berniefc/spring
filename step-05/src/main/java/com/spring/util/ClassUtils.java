package com.spring.util;

/**
 * @author fc
 * @date 2023/12/23 10:39
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back...
        }
        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }

}
