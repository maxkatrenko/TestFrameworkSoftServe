package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IssuesInRepoPage extends AbstractPage {
    public IssuesInRepoPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[contains(@name,'issues[]')]")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//span[contains(@class,'text-gray')]/span")
    private WebElement clickedCheckBoxes;

    @FindBy(xpath = "//span[@class='d-none d-md-block']")
    private WebElement newIssueButton;

    @FindBy(xpath = "//a[contains(text(),'my_test')]")
    private WebElement newIssue;

    public int clickOnRandCheckBoxes() {
        int numberOfCheckBoxes = (int) (Math.random() * checkBoxes.size() + 1);
        for (int i = 0; i < numberOfCheckBoxes; i++) {
            checkBoxes.get(i).click();
        }
        return numberOfCheckBoxes;
    }

    public NewIssuePage clickOnNewIssueButton() {
        newIssueButton.click();
        return new NewIssuePage(webDriver);
    }

    public NewIssuePage clickOnNewIssue() {
        newIssue.click();
        return new NewIssuePage(webDriver);
    }

    public int getClickedCheckBoxes() {
        return Integer.parseInt(clickedCheckBoxes.getText());
    }

    public WebElement getNewIssue() {
        return newIssue;
    }
}
