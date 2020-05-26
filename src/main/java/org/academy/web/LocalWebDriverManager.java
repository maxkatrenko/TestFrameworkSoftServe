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
				String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
				String chromeBinary = "src/main/resources/chromedriver" + (os.equals("win") ? ".exe" : "");
				System.setProperty("webdriver.chrome.driver", chromeBinary);
				WebDriver chromeWebDriver = new ChromeDriver(options);
				chromeWebDriver.manage().timeouts().implicitlyWait(300000, TimeUnit.MILLISECONDS);
				chromeWebDriver.manage().window().maximize();
				return chromeWebDriver;
		}
	}
}
