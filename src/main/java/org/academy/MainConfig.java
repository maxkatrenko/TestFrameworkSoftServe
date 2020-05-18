package org.academy;

public class MainConfig {

    private static String read(String value) {
        return ConfigurationReader.get().readValue(value);
    }

    public static String getUrl() {
        return read("main_url");
    }

    public static String getBrowser() {
        return read("browser");
    }

    public static String getPassword() {
        return read("pass");
    }

    public static String getLogin() {
        return read("login");
    }

    public static String getIssuesUrl() {
        return read("issues_url_lesson");
    }
}
