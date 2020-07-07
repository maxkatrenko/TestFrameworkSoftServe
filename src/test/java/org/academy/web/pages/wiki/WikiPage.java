package org.academy.web.pages.wiki;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiPage extends AbstractPage {
    public WikiPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary' and @href=\"/alhonchar/academylessons/wiki/_new\"]")
    private WebElement newPageBtn;

    @FindBy(xpath = "//span[@class='Counter Counter--gray']")
    private WebElement pageCounter;

    @FindBy(xpath = "//div[@class='container-lg px-2']/button/parent::*")
    private WebElement successMesssage;

    public NewWikiPage clickOnNewPageBtn() {
        newPageBtn.click();
        return new NewWikiPage(webDriver);
    }

    public int getPagesAmount() {
        return Integer.parseInt(pageCounter.getText());
    }

    public String getSuccessMessage() {
        return successMesssage.getText();
    }
}
