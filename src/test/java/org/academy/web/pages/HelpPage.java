package org.academy.web.pages;

import lombok.SneakyThrows;
import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.academy.web.WebHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

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

    @FindBy(xpath = "//tr[@class='zA yO']")
    private List<WebElement> gitHubEmails;

    @FindBy(xpath = "//*[@class=\"a3s aXjCH \"]")
    private WebElement divWithPassword;

    @SneakyThrows
    public String getPasswordFromGmail() {
        WebHelpers.openNewBlankBrowserTab(webDriver);
        WebHelpers.switchToLastOpenedTab(webDriver);
        webDriver.get(MainConfig.getGmailUrl());
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(MainConfig.getEmail());
        nextButton.click();
        Thread.sleep(2000);
        passwordInput.sendKeys(MainConfig.getEmailPassword());
        nextButtonPassword.click();
        inboxLink.click();
        wait.until(ExpectedConditions.visibilityOf(gitHubEmails.get(0))).click();
        String lastEmailText = divWithPassword.getText();
        WebHelpers.switchWindowTab(webDriver, 0);
        return lastEmailText.substring(lastEmailText.length() - 6);

    }

    

    public LoginPage goToLoginPage() {
        this.getPasswordFromGmail();

        return new LoginPage(webDriver);
    }


}
