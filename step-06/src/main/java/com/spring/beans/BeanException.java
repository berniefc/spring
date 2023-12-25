package com.spring.beans;

/**
 * @author fc
 * @date 2023/12/21 17:36
 */
public class BeanException extends RuntimeException{

    public BeanException() {
        super();
    }

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }


}
