package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExplorePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='site-subnav bg-white site-subnav-sticky js-sticky']//a[3]")

    private WebElement trendingLink;

    public ExplorePage(WebDriver webDriver) {
        super(webDriver, false);
    }

    public TrendingPage clickOnTrendingLink() {
        trendingLink.click();
        return new TrendingPage(webDriver);
    }
}
