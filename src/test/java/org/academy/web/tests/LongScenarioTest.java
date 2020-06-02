package org.academy.web.tests;
import org.academy.tools.TestNgListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.academy.web.AbstractWebDriver;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;


public class LongScenarioTest extends AbstractWebDriver {
    private static Logger log = LoggerFactory.getLogger(LongScenarioTest.class);
    private LoginPage loginPage;
    private BasePage basePage;
    private RepositoryPage repositoryPage;
    private ProjectTabPage projectTabPage;
    private KanbanBoardPage kanbanBoardPage;
    private Pull15Page pull15Page;
    private CommitPage commitPage;


    public LongScenarioTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
    }

    @Test
    public void getCommitHashCode() {
        log.info("Start 'LongScenarioTest'");
        repositoryPage = basePage.goToRepositoryLink();
        projectTabPage = repositoryPage.goToProjectTab();
        kanbanBoardPage = projectTabPage.goToFirstProject();
        kanbanBoardPage.expandCardDetails();
        kanbanBoardPage.showDetailsFrame();
        pull15Page = kanbanBoardPage.goToPull15Page();
        commitPage=pull15Page.goToCommitPage();
        String sha = commitPage.getShaValue();
        log.info("Commit hash-code = " + sha);
    }

}
