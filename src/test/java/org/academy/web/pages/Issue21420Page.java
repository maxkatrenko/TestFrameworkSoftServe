package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Issue21420Page extends AbstractPage {

    public Issue21420Page(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//tr[contains(@class,'d-block')]//p")
    private List<WebElement> commentsList;

    public String getCommentLike(String commentText) {
        for (WebElement comment : commentsList) {
            if (comment.getText().contains(commentText)) {
                return comment.getText();
            }
        }
        return "comment is not found";
    }

}
