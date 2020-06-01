package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Collections.max;

@Slf4j
@Ignore
public class GetPopularContentTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private InsightsPage insightsPage;
    private TrafficPage trafficPage;

    public GetPopularContentTest() {
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
        List<String> allContentViews;
        List<String> firstContentViews;
        List <Integer> resultsAllContentViews;
        List <Integer> resultsFirstContentViews;
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        log.info("Launching insights page");
        insightsPage = repositoryPage.clickOnInsights();
        log.info("Launching traffic page");
        trafficPage = insightsPage.clickOnTraffic();
        log.info("Getting list of views");

        allContentViews = trafficPage.getAllContentViews();
        resultsAllContentViews= trafficPage.convertToInteger(allContentViews);
        log.info("All popular content Views: " + resultsAllContentViews);

        firstContentViews=trafficPage.getFirstContentViews();
        resultsFirstContentViews=trafficPage.convertToInteger(firstContentViews);
        log.info("First content Views: " + resultsFirstContentViews);

        log.info("MAX amount of views from popular content: " + max(resultsAllContentViews));
        log.info("'alhonchar/academylessons' is has views: " + resultsFirstContentViews.get(0));

        Assert.assertEquals(max(resultsAllContentViews), resultsFirstContentViews.get(0));
        log.info("'alhonchar/academylessons' has MAX amount of views!");
    }
}
