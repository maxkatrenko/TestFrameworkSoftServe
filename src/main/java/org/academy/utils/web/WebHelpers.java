package org.academy.utils.web;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class WebHelpers {

    public static void scrollToElement(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }

    public static void scrollWindowBy(WebDriver driver, int shiftPixels) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript(String.format("window.scrollBy(0,%s);", shiftPixels));
        Thread.sleep(500);
    }

    public static void switchWindowTab(WebDriver driver, int windowInQueue) {
        List<String> listWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listWindows.get(windowInQueue));
    }

    public static void switchToLastOpenedTab(WebDriver driver) {
        ArrayList<String> allTab = new ArrayList<>(driver.getWindowHandles());
        int lastTab = (allTab.size()) - 1;
        driver.switchTo().window(allTab.get(lastTab));
    }

    public static String acceptAlert(WebDriver driver) {
        WebWaiters.waitUntilAlertPresent(driver);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public static void refreshPage(WebDriver webDriver) {
        webDriver.navigate().refresh();
    }

    public static void deleteCookieByName(String name, WebDriver driver) {
        Cookie cookie = driver.manage().getCookies().stream().filter(x -> x.getName().equals(name)).findFirst().get();
        driver.manage().deleteCookie(cookie);
    }

    public static void openNewBlankBrowserTab(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

}
