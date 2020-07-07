package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CommitPage extends AbstractPage {
    public CommitPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[@class='sha user-select-contain']")
    WebElement sha;

    @FindBy(xpath = "//clipboard-copy[@aria-label='Copy the full SHA']")
    private List<WebElement> clipBoardTabs;

    public List<String> getFullShas() {
        return wait
                .until(ExpectedConditions.visibilityOfAllElements(clipBoardTabs)).stream()
                .map(a -> a.getAttribute("value")).collect(Collectors.toList());
    }

    public String getShaValue() {
        return sha.getText();
    }
}
