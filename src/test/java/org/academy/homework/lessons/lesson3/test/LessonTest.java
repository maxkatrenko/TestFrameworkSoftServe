package org.academy.homework.lessons.lesson3.test;

import lombok.extern.slf4j.Slf4j;
import org.academy.homework.lessons.lesson3.config.MainConfigLesson;
import org.academy.homework.lessons.lesson3.pages.LoginPage;
import org.academy.homework.lessons.lesson3.pages.MainPage;
import org.academy.homework.lessons.lesson3.pages.issues.Issue21420;
import org.academy.web.AbstractWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class LessonTest extends AbstractWebDriver {

    private MainPage mainPage;
    private LoginPage loginPage;

    public LessonTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        mainPage = new MainPage(webDriver, true, MainConfigLesson.getUrl());
        log.info("trying to login into github account");
        loginPage = mainPage.clickOnSignIn()
                .enterUsername(MainConfigLesson.getUsername())
                .enterPassword(MainConfigLesson.getPassword())
                .clickOnSubmit();
        log.info("logged in into github account");
    }

    @Test
    public void getCommentTest() {
        log.info("Test launched");
        String commitmentText =
                loginPage
                        .clickOnIssuesLink()
                        .clickOnIssue21420()
                        .getIssueText();
        Assert.assertEquals(commitmentText, "Check this message");
        log.info("Comment 21-4-20: " + commitmentText);
        log.info("Test passed");
    }


//    @Test
//    public void commitmentTest() {
//        webDriver.findElement(By.xpath("//a[contains(text(),'Issues')]")).click();
//        log.info("clicked on 'Issues' link");
//        webDriver.findElement(By.xpath("//a[@id='issue_3_alhonchar_academylessons_link']")).click();
//        log.info("clicked on 'Issue 21-4-20' link");
//        String commitment = webDriver.findElement(By.xpath("//p[contains(text(),'Check this message')]")).getText();
//        log.info("Commitment: " + commitment);
//    }

}
