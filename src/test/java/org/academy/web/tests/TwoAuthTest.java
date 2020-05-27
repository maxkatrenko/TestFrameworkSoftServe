package org.academy.web.tests;

import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.HelpPage;
import org.academy.web.pages.MainPage;
import org.testng.annotations.Test;

public class TwoAuthTest extends AbstractWebDriver {

    @Test
    public void getPass(){
        MainPage mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        mainPage.clickOnSignIn();
        HelpPage helpPage = new HelpPage(webDriver);
        System.out.println(helpPage.getPasswordFromGmail());

    }

}
