package org.academy;

public class MainConfig {

    private static String read(String value) {
        return ConfigurationReader.get().readValue(value);
    }

    public static String getUrl() {
        return read("main_url_lesson");
    }

    public static String getBrowser() {
        return read("browser_lesson");
    }

    public static String getPassword() {
        return read("password_lesson");
    }

    public static String getLogin() {
        return read("username_lesson");
    }

    public static String getIssuesUrl() {
        return read("issues_url_lesson");
    }

    public static String getIssue21420Url() {
        return read("issue21420_url_lesson");
    }
}
