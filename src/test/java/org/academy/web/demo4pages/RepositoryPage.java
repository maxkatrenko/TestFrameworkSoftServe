package org.academy.web.demo4pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage extends AbstractPage {
    @FindBy(xpath = "//span[contains(text(),'Issues')]")
    private WebElement issuesInRepoLink;

    public RepositoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public IssuesInRepoPage clickOnIssuesInRepoLink() {
        issuesInRepoLink.click();
        return new IssuesInRepoPage(webDriver);
    }

}
