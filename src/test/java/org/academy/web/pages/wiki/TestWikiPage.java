package org.academy.web.pages.wiki;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestWikiPage extends AbstractPage {
    public TestWikiPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[@class='btn btn-sm ml-0' and contains(text(), 'Edit')]")
    private WebElement editBtn;

    @FindBy(xpath = "//span[@class='Counter Counter--gray']")
    private WebElement pageCounter;

    public TestWikiEditPage editPage() {
        editBtn.click();
        return new TestWikiEditPage(webDriver);
    }

    public int getPagesAmount() {
        return Integer.parseInt(pageCounter.getText());
    }

}
