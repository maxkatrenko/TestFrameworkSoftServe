package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommitPage extends AbstractPage {
    public CommitPage(WebDriver webDriver) {
        super(webDriver, false);
    }
    @FindBy(xpath = "//span[@class='sha user-select-contain']")
    WebElement sha;

    public String getShaValue(){
        return sha.getText();
    }
}