package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.tools.TestNgListener;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.MarketplacePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
@Listeners(TestNgListener.class)
public class MarketplaceTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private MarketplacePage marketplacePage;

    public MarketplaceTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start 'MarketplaceTest'");
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void slackResults() {
        String results;
        log.info("Launching marketplace page");
        marketplacePage = basePage.clickOnMarket();
        log.info("Entering app's name for search");
        marketplacePage.searchApp(MainConfig.getSearchApp());
        log.info("Getting results");
        results = marketplacePage.results();
        log.info("Total: " + results);
    }

}
