package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ForksPage extends AbstractPage {
    public ForksPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//div[contains(@class,'repo')]//a[contains(@data-hovercard-type, 'user')][position() > 1]")
    private List<WebElement> users;

    public List<String> userNames() {
        List<String> res = new ArrayList<>();
        for (WebElement user : users) {
            res.add(user.getText());
        }
        return res;
    }

}

