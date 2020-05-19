package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.MainPage;
import org.academy.web.pages.MarketplacePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class MarketplaceTest extends AbstractWebDriver {
    private MainPage mainPage;
    private LoginPage loginPage;
    private MarketplacePage marketplacePage;

    public MarketplaceTest() {
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

    @Test
    public void slackResults() {
        String results;
        log.info("Launching marketplace page");
        marketplacePage = mainPage.clickOnMarket();
        log.info("Entering app's name for search");
        marketplacePage.searchApp(MainConfig.getSearchApp());
        log.info("Getting results");
        results = marketplacePage.results();
//        Assert.assertNotNull(results);
        log.info("Total: " + results);
    }

}
