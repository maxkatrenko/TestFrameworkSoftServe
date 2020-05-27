package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Pull15Page extends AbstractPage {
    public Pull15Page(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@href=\"/alhonchar/academylessons/pull/15/commits\"]")
    private WebElement commitsLink;


    public CommitPage clickOnCommitsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(commitsLink)).click();
        return new CommitPage(webDriver);
    }
}
