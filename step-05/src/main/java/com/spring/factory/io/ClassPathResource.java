package com.spring.factory.io;

import cn.hutool.core.lang.Assert;
import com.spring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fc
 * @date 2023/12/23 10:35
 */
public class ClassPathResource implements Resource {

    private final String filePath;

    private ClassLoader classLoader;

    public ClassPathResource(String filePath) {
        this(filePath, (ClassLoader) null);
    }

    public ClassPathResource(String filePath, ClassLoader classLoader) {
        Assert.notNull(filePath, "File path must not be null");
        this.filePath = filePath;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    public String getFilePath() {
        return filePath;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(filePath);
        if (is == null) {
            throw new IOException("Could not open file " + filePath);
        }

        return is;
    }
}
