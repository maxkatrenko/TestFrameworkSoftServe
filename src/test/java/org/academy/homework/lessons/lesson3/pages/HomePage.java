package org.academy.homework.lessons.lesson3.pages;

import org.academy.MainConfig;
import org.academy.homework.lessons.lesson3.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    private WebElement issuesLink;

    public IssuesPage clickOnIssuesLink() {
        issuesLink.click();
        return new IssuesPage(webDriver,true, MainConfig.getIssuesUrl());
    }
}
