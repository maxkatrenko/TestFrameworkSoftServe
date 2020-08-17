package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuePage extends AbstractPage {

    public IssuePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//strong[contains(text(),'Delete issue')]")
    private WebElement deleteIssueButton;

    @FindBy(xpath = "//button[@name='verify_delete']")
    private WebElement confirmButton;

    public IssuePage clickDeleteAndConfirmButton() {
        deleteIssueButton.click();
        confirmButton.click();
        return this;
    }
}
