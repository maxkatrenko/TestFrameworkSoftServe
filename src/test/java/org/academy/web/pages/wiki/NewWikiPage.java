package org.academy.web.pages.wiki;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWikiPage extends AbstractPage {
    public NewWikiPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//input[@id='gollum-editor-page-title']")
    private WebElement title;

    @FindBy(xpath = "//textarea[@id='gollum-editor-body']")
    private WebElement pageBody;

    @FindBy(xpath = "//button[@id='gollum-editor-submit']")
    private WebElement submitBtn;

    public TestWikiPage createPage() {
        title.sendKeys(MainConfig.getPageTitle());
        pageBody.sendKeys(MainConfig.getPageBody());
        submitBtn.click();
        return new TestWikiPage(webDriver, true, MainConfig.getTestPageUrl());
    }
}
