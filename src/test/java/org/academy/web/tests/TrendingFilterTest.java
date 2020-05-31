package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class TrendingFilterTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private ExplorePage explorePage;
    private TrendingPage trendingPage;

    public TrendingFilterTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void filterTrending() {
        explorePage = basePage.clickOnExploreLink();
        log.info("Click on explore link");
        trendingPage = explorePage.clickOnTrendingLink();
        log.info("Click on trending link");
        trendingPage.clickOndropDownLanguage();
        log.info("Click on drop down 'Language'");
        trendingPage.clickOnJavaLanguage();
        log.info("Click on 'Java'");
        trendingPage.clickOndropDownDateRange();
        log.info("Click on drop down 'Date Range'");
        trendingPage.clickOnThisMonth();
        log.info("Click on 'This Month'");
    }
}