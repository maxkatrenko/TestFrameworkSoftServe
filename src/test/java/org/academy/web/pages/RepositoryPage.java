package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.academy.web.WebWaiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RepositoryPage extends AbstractPage {
    public RepositoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//ul[@class='list-style-none']//a[contains (@data-selected-links, 'repo_projects')]")
    private WebElement projectsTab;

    @FindBy(xpath = "//li[contains(@class,'position-relative float-left')]//a[1]")
    private WebElement onActionLink;

    @FindBy(xpath = "//li[8]//a[1]")
    private WebElement insightsBtn;

    @FindBy(xpath = "//a[@href=\"/alhonchar/academylessons/pulls\"]/div")
    private WebElement pullRequestsTab;

    public PullPage clickOnPullRequestsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(pullRequestsTab)).click();
        return new PullPage(webDriver);
    }

    public ProjectTabPage goToProjectTab() {
        WebWaiters.waitUntilElementIsClickable(webDriver, projectsTab);
        projectsTab.click();
        return new ProjectTabPage(webDriver);
    }

    public ActionPage clickOnActionLink() {
        onActionLink.click();
        return new ActionPage(webDriver);
    }

    public InsightsPage clickOnInsights() {
        insightsBtn.click();
        return new InsightsPage(webDriver);
    }

}

