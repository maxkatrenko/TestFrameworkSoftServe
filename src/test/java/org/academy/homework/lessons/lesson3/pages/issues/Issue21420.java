package org.academy.homework.lessons.lesson3.pages.issues;

import org.academy.homework.lessons.lesson3.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Issue21420 extends AbstractPage {
    public Issue21420(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//p[contains(text(),'Check this message')]")
    private WebElement commitmentText;

    public String getIssueText() {
        return commitmentText.getText();
    }

}
