package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RunActionPage extends AbstractPage {
    public RunActionPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//a[@class='muted-link no-underline d-inline text-normal']")
    private WebElement actionHashCode;

    public String getActionHashCode() {
        String url = actionHashCode.getAttribute("href");
        return url.substring(url.lastIndexOf('/') + 1);

    }
}
