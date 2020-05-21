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


    public LoginPage clickOnSignIn() {
        signInButton.click();
        return new LoginPage(webDriver);
    }

}
