package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Issue21420Page extends AbstractPage {

    @FindBy(xpath = "//tr[contains(@class,'d-block')]//p")
    private List<WebElement> commentsList;

    public Issue21420Page(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    public String getLastComment() {
        return commentsList.get(commentsList.size() - 1).getText();
    }
}
