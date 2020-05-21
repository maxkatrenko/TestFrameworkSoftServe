package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {

    public BasePage(WebDriver webDriver) {
        super(webDriver, false, "");
    }


    public BasePage(WebDriver webDriver, boolean navigateToPage) {
        super(webDriver, navigateToPage);
    }

    private WebElement toRepositoryLink = webDriver.findElement(By.xpath("//div[@id='dashboard-repos-container']"
                                            + "//span[@class='css-truncate css-truncate-target'][contains(text(),'"
                                            + MainConfig.getParam("repository") +"')]"));

    public RepositoryPage goToRepositoryLink() {
        toRepositoryLink.click();
        return new RepositoryPage(webDriver);
    }
}
