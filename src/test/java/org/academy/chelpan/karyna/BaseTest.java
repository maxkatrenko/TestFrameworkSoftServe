package org.academy.chelpan.karyna;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void loginTest() {
        OperationSystem.launchDriver();
        driver = new ChromeDriver();
        log.info("New driver instantiated");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Implicit wait applied on the driver for 10 seconds");
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        log.info("Web application launched");
        driver.findElement(By.xpath("//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]")).click();
        log.info("Click action performed on login link");
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("alhonchar");
        log.info("Username entered in the Username text box");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Alex123456&*");
        log.info("Password entered in the Password text box");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        log.info("Click action performed on Submit button");
    }
    @Test
    public void checkLinksTest() {
        driver.findElement(By.xpath("//a[contains(text(),'Blog')]")).click();
        log.info("Click action performed on Blog link");
        driver.findElement(By.xpath("//h1[@class='site-branding__title h4 text-normal pl-3 mt-1 alt-mono-font']"));
        log.info("Element contains on the page");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        log.info("Click action performed on About link");
        driver.findElement(By.xpath("//h1[@class='f00-light lh-condensed mb-4 text-center']"));
        log.info("Element contains on the page");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        log.info("Click action performed on Shop link");
        driver.findElement(By.xpath("//a[@class='nav__cart']"));
        log.info("Element contains on the page");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Contact GitHub')]")).click();
        log.info("Click action performed on Contact GitHub link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Pricing')]")).click();
        log.info("Click action performed on Pricing link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'API')]")).click();
        log.info("Click action performed on API link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Training')]")).click();
        log.info("Click action performed on Training link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Status')]")).click();
        log.info("Click action performed on Status link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Security')]")).click();
        log.info("Click action performed on Security link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Terms')]")).click();
        log.info("Click action performed on Terms link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[contains(text(),'Privacy')]")).click();
        log.info("Click action performed on Privacy link");
        driver.get("https://github.com/");
        log.info("Return on main page");

        driver.findElement(By.xpath("//a[@class='link-gray'][contains(text(),'Help')]")).click();
        log.info("Click action performed on Help link");
        driver.get("https://github.com/");
        log.info("Return on main page");
    }
    @AfterTest(alwaysRun = true)
    public void stopDriverTest() {
        driver.close();
        log.info("Browser closed");
    }
}
