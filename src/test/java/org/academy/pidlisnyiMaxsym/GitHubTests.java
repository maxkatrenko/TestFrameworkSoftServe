package org.academy.pidlisnyiMaxsym;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class GitHubTests {

    private String baseUrl = "https://github.com/";
    private WebDriver webDriver;
    private String expected = null;
    private String actual = null;

    @BeforeTest
    public void launchBrowser() {
        log.info("Start of Test");
        log.info("OS: " + System.getProperty("os.name"));
        OsQualifier.checkOs();
        webDriver = new ChromeDriver();
        log.info("Added webdriver");
        webDriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        webDriver.manage().window().maximize();
        log.info("Maximize browser window");
    }

    @AfterMethod
    public void verifyMainPage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
        log.info("Return to main page");
        expected = "GitHub";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
    }

    @Test()
    public void login() {
        log.info("Start of login testing");
        webDriver.get(baseUrl);
        log.info("Launched main page");
        webDriver.findElement(By.xpath("//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]")).click();
        log.info("Launched login page");
        webDriver.findElement(By.xpath("//input[@name='login']")).clear();
        webDriver.findElement(By.xpath("//input[@name='login']")).sendKeys("alhonchar");
        log.info("Entered username");
        webDriver.findElement(By.xpath("//input[@name='password']")).clear();
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("Alex123456&*");
        log.info("Entered password");
        webDriver.findElement(By.xpath("//input[@name='commit']")).click();
        log.info("Submit form");
    }

    @Test(priority = 1)
    public void blogPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Blog')]")).click();
        log.info("Launched Blog page");
        expected = "The GitHub Blog - Updates, ideas, and inspiration from GitHub to help developers build and design software.";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 2)
    public void aboutPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        log.info("Launched About page");
        expected = "About";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 3)
    public void shopPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        log.info("Launched Shop page");
        expected = "GitHub Shop | Awesome GitHub T-shirts and other cool swag";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 4)
    public void contactPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Contact GitHub')]")).click();
        log.info("Launched Contact page");
        expected = "GitHub Support";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 5)
    public void pricingPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Pricing')]")).click();
        log.info("Launched Pricing page");
        expected = "Pricing · Plans for every developer";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 6)
    public void apiPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'API')]")).click();
        log.info("Launched API page");
        expected = "GitHub Developer | GitHub Developer Guide";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 7)
    public void trainingPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Training')]")).click();
        log.info("Launched Training page");
        expected = "GitHub Professional Services | From idea to implementation, our experts are ready to help your team get wherever you want to go. Start a conversation with us about how we can bring your goals to life.";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 8)
    public void statusPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Status')]")).click();
        log.info("Launched Status page");
        expected = "GitHub Status";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }


    @Test(priority = 9)
    public void securityPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Security')]")).click();
        log.info("Launched Security page");
        expected = "GitHub Security";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 10)
    public void termsPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Term')]")).click();
        log.info("Launched Terms page");
        expected = "GitHub Terms of Service - GitHub Help";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 11)
    public void privacyPage() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Privacy')]")).click();
        log.info("Launched Privacy page");
        expected = "GitHub Privacy Statement - GitHub Help";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @Test(priority = 12)
    public void helpPage() {
        webDriver.findElement(By.xpath("//a[@class='link-gray'][contains(text(),'Help')]")).click();
        log.info("Launched Help page");
        expected = "GitHub.com Help Documentation";
        actual = webDriver.getTitle();
        Assert.assertEquals(actual, expected);
        log.info("Checked whether title is correct");
    }

    @AfterTest
    public void terminateBrowser() {
        webDriver.close();
        log.info("Closed webdriver");
        log.info("Finished test");
    }


}
