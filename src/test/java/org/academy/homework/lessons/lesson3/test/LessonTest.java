package org.academy.homework.lessons.lesson3.test;

import lombok.extern.slf4j.Slf4j;
import org.academy.homework.lessons.lesson3.config.MainConfigLesson;
import org.academy.homework.lessons.lesson3.page.LoginPage;
import org.academy.homework.lessons.lesson3.page.MainPage;
import org.academy.web.AbstractWebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class LessonTest extends AbstractWebDriver {

    public LessonTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        MainPage mainPage = new MainPage(webDriver, true, MainConfigLesson.getUrl());
        log.info("trying to login into github account");
        LoginPage loginPage = mainPage.clickOnSignIn();
        loginPage.enterUsername(MainConfigLesson.getUsername());
        loginPage.enterPassword(MainConfigLesson.getPassword());
        loginPage.clickOnSubmit();
        log.info("logged in into github account");
    }

    @Test
    public void commitmentTest() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Issues')]")).click();
        log.info("clicked on 'Issues' link");
        webDriver.findElement(By.xpath("//a[@id='issue_3_alhonchar_academylessons_link']")).click();
        log.info("clicked on 'Issue 21-4-20' link");
        String commitment = webDriver.findElement(By.xpath("//p[contains(text(),'Check this message')]")).getText();
        log.info("Commitment: " + commitment);
    }

}
