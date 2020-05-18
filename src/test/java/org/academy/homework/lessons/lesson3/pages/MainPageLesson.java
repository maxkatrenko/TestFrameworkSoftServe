package org.academy.homework.lessons.lesson3.pages;

import org.academy.homework.lessons.lesson3.AbstractPageLesson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageLesson extends AbstractPageLesson {
    public MainPageLesson(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    public LoginPageLesson clickOnSignIn() {
        signInButton.click();
        return new LoginPageLesson(webDriver);
    }

}
