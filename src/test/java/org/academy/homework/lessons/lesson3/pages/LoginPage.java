package org.academy.homework.lessons.lesson3.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver,false,"");
    }

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    private WebElement issuesLink;

    @BeforeTest
    public LoginPage clearAllFields() {
        loginField.clear();
        passwordField.clear();
        return this;
    }

    public LoginPage enterUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnSubmit() {
        submitButton.click();
        return this;
    }

    public IssuesPage clickOnIssuesLink() {
        issuesLink.click();
        return new IssuesPage(webDriver,true, "https://github.com/issues");
    }
}
