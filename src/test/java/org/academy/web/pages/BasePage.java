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

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    private WebElement issuesLink;

    public IssuesPage clickOnIssuesLink() {
        issuesLink.click();
        return new IssuesPage(webDriver, true, MainConfig.getIssuesUrl());
    }

    private WebElement toRepositoryLink = webDriver.findElement(By.xpath("//div[@id='dashboard-repos-container']"
            + "//span[@class='css-truncate css-truncate-target'][contains(text(),'"
            + MainConfig.getParam("repository") +"')]"));

    @FindBy(xpath = "//a[@class='js-selected-navigation-item Header-link py-lg-3 d-inline-block'][contains(text(), 'Marketplace')]")
    private WebElement marketplaceBtn;

    public RepositoryPage goToRepositoryLink() {
        toRepositoryLink.click();
        return new RepositoryPage(webDriver);
    }

    public MarketplacePage clickOnMarket() {
        marketplaceBtn.click();
        return new MarketplacePage(webDriver);
    }
}

