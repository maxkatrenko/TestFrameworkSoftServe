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

    public RunActionPage clickOnWorkflow() {
        workflowLink.click();
        return new RunActionPage(webDriver);
    }
}
