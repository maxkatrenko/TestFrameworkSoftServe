package org.academy.web.tests;

import lombok.extern.slf4j.Slf4j;
import org.academy.web.AbstractWebDriver;
import org.academy.web.WebHelpers;
import org.academy.web.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class LabelTest extends AbstractWebDriver {
    private BasePage basePage;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;
    private PullPage pullPage;
    private LabelsPage labelsPage;

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        log.info("Start 'LabelTest'");
        loginPage = new LoginPage(webDriver, true);
        basePage = loginPage.login();
        log.info("Logged in");
    }

    @Test
    public void checkLabel() {
        int labels;
        log.info("Launching repository page");
        repositoryPage = basePage.goToRepositoryLink();
        pullPage = repositoryPage.clickOnPullRequestsTab();
        labelsPage = pullPage.clickOnLabels();
        log.info("Launched labels page");
        labels = labelsPage.getLabelsAmount();
        log.info("Labels amount:" + labels);
        labelsPage.addNewLabel();
        log.info("Added new label");
        WebHelpers.refreshPage(webDriver);
        log.info(String.valueOf(labelsPage.getLabelsAmount()));
        assertThat(labels).isNotEqualTo(labelsPage.getLabelsAmount());
        labelsPage.deleteLabel();
        log.info("Deleted label");
        assertThat(labels).isEqualTo(labelsPage.getLabelsAmount());
    }

}
