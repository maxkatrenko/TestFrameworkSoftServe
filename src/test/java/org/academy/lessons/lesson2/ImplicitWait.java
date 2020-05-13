package org.academy.lessons.lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com/");

        driver.findElement(By.xpath("//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("alhonchar");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Alex123456&*");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'Header-link notification-indicator')]")).click();

        driver.close();
    }
}
