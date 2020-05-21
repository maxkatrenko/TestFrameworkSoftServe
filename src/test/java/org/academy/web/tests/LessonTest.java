package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.pages.BasePage;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class LessonTest extends AbstractWebDriver {

    private MainPage mainPage;
    private BasePage homePage;

    public LessonTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        mainPage = new MainPage(webDriver, true, MainConfig.getMainUrl());
        log.info("trying to login into github account");
        homePage = mainPage.clickOnSignIn()
                .fillLoginField(MainConfig.getLogin())
                .fillPassField(MainConfig.getPassword())
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
