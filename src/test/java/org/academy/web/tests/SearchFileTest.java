package org.academy.chelpan.karyna.lessons3.tests;

import org.academy.MainConfig;
import org.academy.chelpan.karyna.lessons3.pages.CodePage;
import org.academy.web.AbstractWebDriver;
import org.academy.chelpan.karyna.lessons3.pages.LoginPage;
import org.academy.chelpan.karyna.lessons3.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFileTest extends AbstractWebDriver {
    private LoginPage loginPage;
    private MainPage mainPage;
    private CodePage codePage;

    public SearchFileTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        mainPage = new MainPage(webDriver, true, MainConfig.getUrl());
        loginPage = mainPage.clickOnSignIn();
        loginPage.fillLoginField(MainConfig.getLogin());
        loginPage.fillPassField(MainConfig.getPassword());
        loginPage.clickOnSubmit();
    }

    @Test
    public void fileContentTest() {
        mainPage.clickOnRepositoryLink();
        codePage = mainPage.clickOnFindFile();
        codePage.fillNameFile(MainConfig.getFile());
        codePage.clickOnFile();
        String text = codePage.getFileContent();
        Assert.assertTrue(text.contains("log4j.rootCategory=DEBUG, stdout, file"));
    }
}