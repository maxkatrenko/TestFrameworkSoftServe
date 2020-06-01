package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewIssuePage extends AbstractPage {
    public NewIssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='issue_title']")
    private WebElement titleField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitNewIssueButton;

    @FindBy(xpath = "//ul[@class='list-style-none']//span[contains(text(),'Issues')]")
    private WebElement issuesInRepoLink;

    @FindBy(xpath = "//strong[contains(text(),'Delete issue')]")
    private WebElement deleteIssue;

    @FindBy(xpath = "//button[@name='verify_delete']")
    private WebElement submitDeleteButton;

    public NewIssuePage fillTheTitle(String string) {
        titleField.sendKeys(string);
        return new NewIssuePage(webDriver);
    }

    public NewIssuePage clickOnSubmitNewIssueButton() {
        submitNewIssueButton.click();
        return new NewIssuePage(webDriver);
    }

    public IssuesInRepoPage clickOnIssuesInRepoLink() {
        issuesInRepoLink.click();
        return new IssuesInRepoPage(webDriver);
    }

    public IssuesInRepoPage clickOnDeleteIssue() {
        deleteIssue.click();
        submitDeleteButton.click();
        return new IssuesInRepoPage(webDriver);
    }
}
