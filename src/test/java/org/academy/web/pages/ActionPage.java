package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionPage extends AbstractPage {
    public ActionPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//a[contains(text(),'test file commit')]")
    private WebElement workflowLink;

    @FindBy(xpath = "//summary[contains(text(),'Branch')]")
    private WebElement branches;

    @FindBy(linkText = "check_branch")
    private WebElement checkBranch;

    public void findParticularBranch() {
        branches.click();
        checkBranch.click();
    }

    public RunActionPage goToRunActionPage() {
        findParticularBranch();
        workflowLink.click();
        return new RunActionPage(webDriver);
    }
}