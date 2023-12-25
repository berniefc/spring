package com.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 *@author fc
 *@date 2023/12/23 10:32
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
