package org.academy.pidlisnyiMaxsym;

class OsQualifier {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    static void checkOs() {
        if (isUnix()) {
            System.out.println("Hi unix user!");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        } else if (isWindows()) {
            System.out.println("Hi windows user!");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        } else {
            System.out.println("Sorry: Your OS is not supported!");
        }
    }
}
