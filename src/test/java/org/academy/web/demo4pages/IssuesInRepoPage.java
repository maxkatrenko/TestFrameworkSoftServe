package org.academy.web.demo4pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IssuesInRepoPage extends AbstractPage {
    public IssuesInRepoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[contains(@data-hovercard-type,\"issue\")]")
    private List<WebElement> listOfIssues;

    public boolean checkIsIssuePresentByName(String name) {
        for (WebElement issue : listOfIssues) {
            if (issue.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public IssuePage clickOnIssueByName(String name) {
        String xpath = "//a[contains(text(),'" + name + "')]";

        webDriver.findElement(By.xpath(xpath)).click();
        return new IssuePage(webDriver);
    }

}
