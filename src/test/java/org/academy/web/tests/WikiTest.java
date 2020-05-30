package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.BasePage;
import org.academy.web.pages.LoginPage;
import org.academy.web.pages.RepositoryPage;
import org.academy.web.pages.wiki.NewWikiPage;
import org.academy.web.pages.wiki.TestWikiEditPage;
import org.academy.web.pages.wiki.TestWikiPage;
import org.academy.web.pages.wiki.WikiPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class WikiTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private WikiPage wikiPage;
    private NewWikiPage newWikiPage;
    private TestWikiEditPage editPage;
    private TestWikiPage testWikiPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start 'WikiTest'");
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void newPageTest() {
        int pages;
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        wikiPage = repositoryPage.clickInWikiTab();
        pages = wikiPage.getPagesAmount();
        newWikiPage = wikiPage.clickOnNewPageBtn();
        testWikiPage = newWikiPage.createPage();
        assertThat(pages).isNotEqualTo(testWikiPage.getPagesAmount());
        editPage = testWikiPage.editPage();
        wikiPage = editPage.deletePage();
        assertThat(pages).isEqualTo(wikiPage.getPagesAmount());
    }
}
