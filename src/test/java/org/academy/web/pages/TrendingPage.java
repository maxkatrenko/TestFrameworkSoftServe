package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrendingPage extends AbstractPage {
    public TrendingPage(WebDriver webDriver) {
        super(webDriver, false);
    }
    @FindBy(xpath = "//div[@class='mb-3 mb-sm-0']//span[@class='text-bold']")
    private WebElement dropDownLanguage;

    @FindBy(xpath = "//details[@id='select-menu-language']//a[3]//*[contains(text(),'Java')]")
    private WebElement javaLanguage;

    @FindBy(xpath = "//details[@id='select-menu-date']//summary//span")
    private WebElement dropDownDateRange;

    @FindBy(xpath = "//span[contains(text(),'This week')]")
    private WebElement thisMonthDateRange;

    public TrendingPage clickOndropDownLanguage() {
        dropDownLanguage.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOnJavaLanguage() {
        javaLanguage.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOndropDownDateRange() {
        dropDownDateRange.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOnThisMonth() {
        thisMonthDateRange.click();
        return new TrendingPage(webDriver);
    }
}
