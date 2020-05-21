package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage extends AbstractPage {
    public RepositoryPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//li[contains(@class,'position-relative float-left')]//a[1]")
    private WebElement onActionLink;

    public ActionPage clickOnActionLink() {
        onActionLink.click();
        return new ActionPage(webDriver);
    }
}