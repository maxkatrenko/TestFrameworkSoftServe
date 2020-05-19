package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class UserTest extends AbstractWebDriver {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private InsightsPage insightsPage;
    private ForksPage forksPage;

    public UserTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start of test");
        mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        loginPage = mainPage.clickOnSignIn();
        log.info("Entering password and email to login");
        loginPage.fillLoginField(MainConfig.getLogin());
        loginPage.fillPassField(MainConfig.getPassword());
        log.info("Submitting form");
        loginPage.clickOnSubmit();
    }

    @Test(description = "get forked users and check them in 'Network'")
    public void forkedUsersCheck() {
        List<String> forkedUsers;
        log.info("Launching repository page");
        repositoryPage = mainPage.clickOnRep();
        log.info("Launching insights page");
        insightsPage = repositoryPage.clickOnInsights();
        log.info("Launching forks page");
        forksPage = insightsPage.clickOnForks();
        log.info("Getting list of users who fork repository");
        forkedUsers = forksPage.userNames();
//        Assert.assertNotNull(forkedUsers);
//        Assert.assertTrue(forkedUsers.size() > 0);
        log.info("Forked users: " + forkedUsers);
    }

}
