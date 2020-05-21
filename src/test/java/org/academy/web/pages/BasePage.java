package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {
    public BasePage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//div[@id='dashboard-repos-container']//span[@class='css-truncate css-truncate-target'][contains(text(),'academylessons')]")
    private WebElement toRepositoryLink;

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    private WebElement issuesLink;

    public IssuesPage clickOnIssuesLink() {
        issuesLink.click();
        return new IssuesPage(webDriver, true, MainConfig.getIssuesUrl());
    }

    public RepositoryPage getRepositoryLink() {
        toRepositoryLink.click();
        return new RepositoryPage(webDriver);
    }
}
