package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passField;
    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitForm;
    @FindBy(xpath = "//div[@class='container-lg px-2']")
    private WebElement errorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    public LoginPage(WebDriver webDriver, boolean navigateToPage) {
        super(webDriver, navigateToPage);
    }

    public LoginPage fillLoginField(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage fillPassField(String pass) {
        passField.sendKeys(pass);
        return this;
    }

    public BasePage clickOnSubmit() {
        submitForm.click();
        return new BasePage(webDriver);
    }

    public BasePage clickOnSignIn() {
        return new BasePage(webDriver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public BasePage login() {
        loginField.sendKeys(TestConfigurations.getLogin());
        passField.sendKeys(TestConfigurations.getPassword());
        submitForm.click();
        return new BasePage(webDriver);
    }
}