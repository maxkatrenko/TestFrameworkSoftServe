package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.academy.web.WebHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HelpPage extends AbstractPage {
    public HelpPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//a[@class=\"h-c-header__nav-li-link \"]")
    private List<WebElement> signInLinks;

    @FindBy(xpath = "//input[@id=\"identifierId\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@id=\"identifierNext\"]")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement nextButtonPassword;

    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/u/0/#inbox']")
    private WebElement inboxLink;

    @FindBy(xpath = "//span[text()='[GitHub] Please verify your device']")
    private List<WebElement> gitHubEmails;

    @FindBy(xpath = "//*[@id=\":wy\"]")
    private WebElement divWithPassword;

    public String getPasswordFromGmail(){
        WebHelpers.openNewBlankBrowserTab(webDriver);
        webDriver.get(MainConfig.getGmailUrl());
        //wait.until(ExpectedConditions.elementToBeClickable(signInLinks.get(0))).click();
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(MainConfig.getEmail());
        nextButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(MainConfig.getEmailPassword());
        nextButtonPassword.click();
        wait.until(ExpectedConditions.elementToBeClickable(inboxLink)).click();
        wait.until(ExpectedConditions.visibilityOf(gitHubEmails.get(0))).click();
        String lastEmailText = wait.until(ExpectedConditions.visibilityOf(divWithPassword)).getText();
        return lastEmailText.substring(lastEmailText.length()-6);

    }

public LoginPage goToLoginPage(){
        return new LoginPage(webDriver);
}
}
