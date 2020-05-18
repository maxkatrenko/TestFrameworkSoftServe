package org.academy.homework.lessons.lesson3.pages;

import org.academy.homework.lessons.lesson3.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    public LoginPage clickOnSignIn() {
        signInButton.click();
        return new LoginPage(webDriver);
    }

}
