package org.academy.web.tests;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.MainPage;
import org.academy.web.pages.TrendingPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Slf4j
public class TrendingTest extends AbstractWebDriver {

    private TrendingPage trendingPage;

    @SneakyThrows
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        MainPage mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        mainPage.clickOnSignIn()
                .fillLoginField(MainConfig.getLogin())
                .fillPassField(MainConfig.getPassword())
                .clickOnSubmit();
        Thread.sleep(500000);
        //trendingPage = new TrendingPage(webDriver, true, MainConfig.getTrendingUrl());
    }
    @Test
    public void trendingTest(){
        trendingPage.insertSpokenLanguage("English")
                .insertLanguage("Java")
                .getTenRepos().forEach(log::info);
        /*trendingPage.insertSpokenLanguage("")*/
    }

}
