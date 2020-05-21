package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.academy.web.WebWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PullPage extends AbstractPage {
    public PullPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    String commitName = MainConfig.getParam("commit");
    private WebElement commitNameLink = webDriver.findElement(By.linkText(commitName));

    public CommitPage goToCommitPage(){
        WebWaiters.waitUntilElementIsVisible(commitNameLink, webDriver, 10);
        commitNameLink.click();
        return  new CommitPage(webDriver);
    }
}
