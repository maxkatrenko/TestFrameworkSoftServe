package org.academy.chelpan.karyna.lessons3.pages;

import org.academy.chelpan.karyna.lessons3.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitForm;

    @FindBy(xpath = "//div[@class='container-lg px-2']")
    private WebElement errorMessage;

    public LoginPage fillLoginField(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassField(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public LoginPage clickOnSubmit() {
        submitForm.click();
        return this;
    }
}
