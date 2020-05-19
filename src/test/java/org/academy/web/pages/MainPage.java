package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='dashboard-repos-container']//a[@class='d-inline-flex flex-items-baseline" +
            " f5 mb-2 dashboard-underlined-link width-fit']")
    private WebElement repLink;

    @FindBy(xpath = "//a[@class='js-selected-navigation-item Header-link py-lg-3 d-inline-block'][contains(text(), 'Marketplace')]")
    private WebElement marketplaceBtn;

    public LoginPage clickOnSignIn() {
        signInButton.click();
        return new LoginPage(webDriver);
    }

    public RepositoryPage clickOnRep() {
        repLink.click();
        return new RepositoryPage(webDriver);
    }

    public MarketplacePage clickOnMarket() {
        marketplaceBtn.click();
        return new MarketplacePage(webDriver);
    }
}
