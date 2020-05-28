package org.academy.web.tests;

import lombok.SneakyThrows;
import org.academy.MainConfig;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.HelpPage;
import org.academy.web.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Ignore
public class TwoAuthTest extends AbstractWebDriver {
    @SneakyThrows
    @Test
    public void getPass()  {
        MainPage mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        mainPage.clickOnSignIn();
        HelpPage helpPage = new HelpPage(webDriver);
        System.out.println(helpPage.getPasswordFromGmail());

    }
    @BeforeMethod
    public void setImplicitlyWait(){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
