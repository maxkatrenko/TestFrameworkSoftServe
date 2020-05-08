package org.academy.chelpan.karyna;

public class OperationSystem {

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static void launchDriver() {
        System.out.println(OS);
        if (isWindows()) {
            System.out.println("This is Windows");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        } else if (isUnix()) {
            System.out.println("This is Unix or Linux");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        }


    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
}
