package org.academy.web;

import org.academy.tools.TestNgListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

@Listeners(TestNgListener.class)
public abstract class AbstractWebDriver {
    public  WebDriver webDriver = LocalWebDriverManager.getWebDriver();

    @AfterClass
    public void closeDriver() {
        webDriver.close();
    }
}