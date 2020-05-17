package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsightsPage extends AbstractPage {
    public InsightsPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//a[contains(text(),'Forks')]")
    private WebElement forksBtn;

    @FindBy(xpath = "//a[@class='js-selected-navigation-item menu-item'][contains(text(),'Network')]")
    private WebElement networkBtn;

    public ForksPage clickOnForks() {
        forksBtn.click();
        return new ForksPage(webDriver);
    }

    public NetworkPage clickOnNetwork() {
        forksBtn.click();
        return new NetworkPage(webDriver);
    }
}
