package org.academy.web.pages.wiki;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestWikiEditPage extends AbstractPage {
    public TestWikiEditPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//button[@class='btn btn-sm btn-danger' and contains(text(), 'Delete Page')]")
    private WebElement deleteBtn;

    public WikiPage deletePage() {
        deleteBtn.click();
        webDriver.switchTo().alert().accept();
        return new WikiPage(webDriver);
    }
}
