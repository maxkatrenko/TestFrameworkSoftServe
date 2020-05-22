package org.academy.web.pages;

import lombok.SneakyThrows;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketplacePage extends AbstractPage {
    public MarketplacePage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//input[@placeholder='Search for apps and actions']")
    private WebElement searchForm;

    @FindBy(xpath = "//span[@class='text-bold']")
    private WebElement results;

    @SneakyThrows
    public MarketplacePage searchApp(String app) {
        searchForm.sendKeys(app);
        searchForm.submit();
        return this;
    }

    public String results() {
        return results.getText();
    }

}
