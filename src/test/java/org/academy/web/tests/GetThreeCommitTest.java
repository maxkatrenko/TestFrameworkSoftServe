package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class GetThreeCommitTest extends AbstractWebDriver {
    private BasePage basePage;


    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        MainPage mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        mainPage.clickOnSignIn()
                .fillLoginField(MainConfig.getLogin())
                .fillPassField(MainConfig.getPassword())
                .clickOnSubmit();
        basePage = new BasePage(webDriver);
    }

    @Test(description = "put three SHA to log")
    public void getThreeSha() {
        basePage.clickOnAcademyLessonsLink()
                .clickOnPullRequestsTab()
                .clickOnTestFileCommitLink()
                .clickOnCommitsLink()
                .getFullShas().forEach(log::info);
    }


}
