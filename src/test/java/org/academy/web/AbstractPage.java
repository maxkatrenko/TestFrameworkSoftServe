package org.academy.web;

import lombok.extern.slf4j.Slf4j;
import org.academy.MainConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    public AbstractPage(WebDriver webDriver, boolean navigateToPage) {
        String pageUrl = MainConfig.getPageUrl(this.getClass().getSimpleName());
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
        if (navigateToPage && !Objects.equals(webDriver.getCurrentUrl(), pageUrl)) {
            webDriver.get(pageUrl);
            WebHelpers.refreshPage(webDriver);
        }
    }
}
