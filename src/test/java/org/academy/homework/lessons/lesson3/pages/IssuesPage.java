package org.academy.homework.lessons.lesson3.pages;

import org.academy.MainConfig;
import org.academy.homework.lessons.lesson3.AbstractPage;
import org.academy.homework.lessons.lesson3.pages.issues.Issue21420;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;

public class IssuesPage extends AbstractPage {
    public IssuesPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(id = "issue_3_alhonchar_academylessons_link")
    private WebElement issue21420;

    public Issue21420 clickOnIssue21420() {
        issue21420.click();
        return new Issue21420(webDriver,true,
                MainConfig.getIssue21420Url());
    }
}
