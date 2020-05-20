package org.academy.homework.lessons.lesson3.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;

public class LoginPageLesson extends AbstractPage {

    public LoginPageLesson(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitButton;

    @BeforeTest
    public LoginPageLesson clearAllFields() {
        loginField.clear();
        passwordField.clear();
        return this;
    }

    public LoginPageLesson enterUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPageLesson enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public HomePageLesson clickOnSubmit() {
        submitButton.click();
        return new HomePageLesson(webDriver, false,"");
    }
}
