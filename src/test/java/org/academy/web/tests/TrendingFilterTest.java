package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.WebHelpers;
import org.academy.web.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class TrendingFilterTest extends AbstractWebDriver {
    private BasePage basePage;
    private ExplorePage explorePage;
    private TrendingPage trendingPage;


    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        MainPage mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        basePage = mainPage.clickOnSignIn().login();
        log.info("Logged in");
    }

    @AfterMethod(alwaysRun = true)
    public void clearPrecondition() {
        webDriver.manage().deleteAllCookies();
        WebHelpers.refreshPage(webDriver);
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

    @Test
    public void compareTadrendsTest() {
        trendingPage = new TrendingPage(webDriver, true, MainConfig.getTrendingUrl());
        trendingPage.clickOnSpokenLanguageTab()
                .selectEnglishLanguage()
                .clickOnLanguageTab()
                .clickOnJavaLanguage()
                .getTenRepos().forEach(log::info);
        log.info("Count of rus repos = ".concat(String.valueOf(trendingPage.clickOnSpokenLanguageTab()
                .insertInSpokeInput("Russian")
                .selectRussianLanguage()
                .countRusRepos())));
        log.info("Count of arab repos = ".concat(String.valueOf(trendingPage.clickOnSpokenLanguageTab()
                .insertInSpokeInput("Arabic")
                .selectArabianLanguage()
                .clickOnDateRangeTab()
                .selectMonthDateRange()
                .countArabRepos())));
    }


}