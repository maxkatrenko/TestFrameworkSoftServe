package org.academy.homework.lessons.lesson3.config;

public class MainConfigLesson {

    private static String read(String value) {
        return ConfigurationReaderLesson.get().readValue(value);
    }

    public static String getUrl() {
        return read("main_url_lesson");
    }

    public static String getPassword() {
        return read("password_lesson");
    }

    public static String getUsername() {
        return read("username_lesson");
    }
}
