package org.academy.homework.lessons.lesson3.test;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.homework.lessons.lesson3.pages.HomePageLesson;
import org.academy.homework.lessons.lesson3.pages.MainPageLesson;
import org.academy.web.AbstractWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class LessonTest extends AbstractWebDriver {

    private MainPageLesson mainPage;
    private HomePageLesson homePage;

    public LessonTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        mainPage = new MainPageLesson(webDriver, true, MainConfig.getMainUrl());
        log.info("trying to login into github account");
        homePage = mainPage.clickOnSignIn()
                .enterUsername(MainConfig.getLogin())
                .enterPassword(MainConfig.getPassword())
                .clickOnSubmit();
        log.info("logged in into github account");
    }

    @Test
    public void getCommentTest() {
        log.info("Test launched");
        String commitmentText =
                homePage.clickOnIssuesLink()
                        .clickOnIssue21420()
                        .getCommitmentText();
        log.info("Comment 21-4-20: " + commitmentText);
        log.info("Test passed");
    }
}
