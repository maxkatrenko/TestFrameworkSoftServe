package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.tools.TestNgListener;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
@Listeners(TestNgListener.class)
public class ActionTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private MainPage mainPage;
    private BasePage basePage;
    private RepositoryPage repositoryPage;
    private ActionPage actionPage;
    private RunActionPage runActionPage;

    public ActionTest() {
        super();
    }

    public void login() {
        loginPage.fillLoginField(MainConfig.getLogin());
        loginPage.fillPassField(MainConfig.getPassword());
        loginPage.clickOnSubmit();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start 'ActionTest'");
        mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        loginPage = mainPage.clickOnSignIn();   
        login();
        basePage = loginPage.clickOnSignIn();
        log.info("Logged in");
        repositoryPage = basePage.goToRepositoryLink();
        actionPage = repositoryPage.clickOnActionLink();
        runActionPage = actionPage.clickOnWorkflow();
    }

    @Test
    public void getHash() {
        log.info("Hash code " + runActionPage.GetActionHashCode());
    }

}
