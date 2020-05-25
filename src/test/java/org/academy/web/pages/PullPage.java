package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.academy.web.WebWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PullPage extends AbstractPage {
    public PullPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@id='issue_15_link']")
    private WebElement testFileCommitLink;


    String commitName = MainConfig.getParam("commit");
    private WebElement commitNameLink = webDriver.findElement(By.linkText(commitName));

    public Pull15Page clickOnTestFileCommitLink() {
        wait.until(ExpectedConditions.elementToBeClickable(testFileCommitLink)).click();
        return new Pull15Page(webDriver);
    }

    public CommitPage goToCommitPage() {
        WebWaiters.waitUntilElementIsVisible(commitNameLink, webDriver, 10);
        commitNameLink.click();
        return new CommitPage(webDriver);
    }
}
