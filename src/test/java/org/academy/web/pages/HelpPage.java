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
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @FindBy(xpath = "//span[text()='[GitHub] Please verify your device']")
    private List<WebElement> gitHubEmails;

    @FindBy(xpath = "//*[@class=\"a3s aXjCH \"]")
    private WebElement divWithPassword;

    @FindBy(xpath = "//input[@id='otp']")
    private WebElement twoAuthInput;

    @FindBy(xpath = "//button[text()='Verify']")
    private WebElement verifyButton;

    public void insertPassword() {
        twoAuthInput.sendKeys(getPasswordFromGmail());
    }

    @SneakyThrows
    public String getPasswordFromGmail() {
        WebHelpers.openNewBlankBrowserTab(webDriver);
        WebHelpers.switchToLastOpenedTab(webDriver);
        webDriver.get(MainConfig.getGmailUrl());
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(MainConfig.getEmail());
        nextButton.click();
        Thread.sleep(3000);
        passwordInput.sendKeys(MainConfig.getEmailPassword());
        nextButtonPassword.click();
        Thread.sleep(2000);
        inboxLink.click();
        Thread.sleep(4000);
        gitHubEmails.get(1).click();

        String lastEmailText = wait.until(ExpectedConditions.visibilityOf(divWithPassword)).getText();
        Pattern space = Pattern.compile("\\s");
        String[] words = space.split(lastEmailText);
        Pattern pattern = Pattern.compile("\\d{6}");
        List<String> filterWords = Arrays.stream(words).filter(pattern.asPredicate())
                .collect(Collectors.toList());

        WebHelpers.switchWindowTab(webDriver, 0);
        Thread.sleep(500);
        return filterWords.get(filterWords.size() - 1);

    }


    @SneakyThrows
    public LoginPage goToLoginPage() {
        insertPassword();
        verifyButton.click();
        return new LoginPage(webDriver);
    }


}
