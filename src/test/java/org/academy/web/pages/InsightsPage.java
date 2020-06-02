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

    @FindBy(xpath = "//a[contains(text(),'Traffic')]")
    private WebElement trafficBtn;

    public ForksPage clickOnForks() {
        forksBtn.click();
        return new ForksPage(webDriver);
    }
    public TrafficPage clickOnTraffic() {
        trafficBtn.click();
        return new TrafficPage(webDriver);
    }

}
