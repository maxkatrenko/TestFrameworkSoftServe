package org.academy.homework.lessons.lesson3.config;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class ConfigurationReaderLesson {
    {
        copyValues(fromPath("lesson3.properties"), true);
    }

    private static final Properties properties = new Properties();
    private static final ConfigurationReaderLesson INSTANCE = new ConfigurationReaderLesson();

    private ConfigurationReaderLesson() {
    }

    public static ConfigurationReaderLesson get() {
        return INSTANCE;
    }

    public String readValue(final String key) {
        return readValue(key, null);
    }

    public String readValue(final String key, final String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    private void copyValues(final Properties source) {
        copyValues(source, false);
    }

    private void copyValues(final Properties source, boolean overwrite) {
        for (String key : source.stringPropertyNames()) {
            if (overwrite || !properties.containsKey(key)) {
                properties.setProperty(key, source.getProperty(key));
            }
        }
    }

    private Properties fromPath(final String path) {
        Properties properties = new Properties();
        String file;
        try {
            file = Objects.requireNonNull(ConfigurationReaderLesson.class.getClassLoader().getResource(path)).getFile();
            properties.load(new FileInputStream(new File(file)));
        } catch (Exception e) {
            throw new RuntimeException("Cannot find properties file: env.properties", e);
        }
        return properties;
    }
}
