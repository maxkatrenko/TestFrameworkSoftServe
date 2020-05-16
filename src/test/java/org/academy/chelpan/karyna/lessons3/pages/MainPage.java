package org.academy.chelpan.karyna.lessons3.pages;

import org.academy.chelpan.karyna.lessons3.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }
    public MainPage(WebDriver webDriver) {
        super(webDriver, false, "");
    }
    @FindBy(xpath = "//a[(contains(@class, 'HeaderMenu-link')) and (@href='/login')]")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@id='dashboard-repos-container']//div[@class='width-full text-bold']")
    private WebElement repositoryLink;
    @FindBy(xpath="//a[@class='btn btn-sm empty-icon float-right BtnGroup-item']")
    private WebElement findFileButton;

    public LoginPage clickOnSignIn() {
        signInButton.click();
        return new LoginPage(webDriver);
    }
    public MainPage clickOnRepositoryLink() {
        repositoryLink.click();
        return this;
    }
    public CodePage clickOnFindFile() {
        findFileButton.click();
        return new CodePage(webDriver);
    }
}
