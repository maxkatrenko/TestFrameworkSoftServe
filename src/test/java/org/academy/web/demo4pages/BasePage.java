package org.academy.web.demo4pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {
    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[@title=\"demo3\"]")
    private WebElement repLink;

    public RepositoryPage clickOnRepositoryLink() {
        repLink.click();
        return new RepositoryPage(webDriver);
    }

}
