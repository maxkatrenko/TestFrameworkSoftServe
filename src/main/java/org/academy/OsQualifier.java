package org.academy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OsQualifier {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    public static void checkOs() {
        if (isUnix()) {
            log.info("Hi unix user!");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        } else if (isWindows()) {
            log.info("Hi windows user!");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        } else {
            log.info("Sorry: Your OS is not supported!");
        }
    }
}
