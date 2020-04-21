package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {
    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://github.com/");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]"))).click();

        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("alhonchar");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Alex123456&*");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        driver.findElement(By.xpath("//a[contains(@class, 'Header-link notification-indicator')]")).click();

        driver.close();
    }
}
