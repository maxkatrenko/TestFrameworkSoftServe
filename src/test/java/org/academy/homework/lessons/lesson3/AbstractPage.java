package org.academy.homework.lessons.lesson3;

import lombok.extern.slf4j.Slf4j;
import org.academy.web.WebHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

@Slf4j
public class AbstractPage {
    public final WebDriver webDriver;

    public AbstractPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        if (navigateToPage && !Objects.equals(webDriver.getCurrentUrl(), navigateToPageUrl)) {
            webDriver.get(navigateToPageUrl);
            WebHelpers.refreshPage(webDriver);
        }

    }
}
