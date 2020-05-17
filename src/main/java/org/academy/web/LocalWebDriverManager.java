package org.academy.web;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@Slf4j
public class LocalWebDriverManager {

	public static synchronized WebDriver getWebDriver() {
		return getWebDriver(MainConfig.getBrowser());
	}

	public static WebDriver getWebDriver(String browser) {
		switch (browser) {
			default:
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
				WebDriver chromeWebDriver = new ChromeDriver(options);
				chromeWebDriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
				chromeWebDriver.manage().window().maximize();
				return chromeWebDriver;
		}
	}
}
