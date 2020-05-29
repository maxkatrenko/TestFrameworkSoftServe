package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class TrendingPage extends AbstractPage {
    public TrendingPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }

    @FindBy(xpath = "//input[@id='text-filter-field-spoken-language']")
    private WebElement languageInput;

    @FindBy(xpath = "//input[@placeholder=\"Filter languages\"]")
    private WebElement languageFilterInput;

    @FindBy(xpath = "//summary[@class=\"btn-link select-menu-button\"]")
    private List<WebElement> allFilters;

    @FindBy(xpath = "//a[@href='https://github.com/trending/java?since=monthly&spoken_language_code=en']")
    private WebElement thisMonthTimeSpan;

    @FindBy(xpath = "//h1[@class='h3 lh-condensed']")
    private List<WebElement> trendingRepos;

    @FindBy(xpath = "//span[contains(text(),  'Russian')]")
    private WebElement russianLang;

    public TrendingPage insertSpokenLanguage(String lang) {
        languageInput.sendKeys(lang + Keys.ENTER);
        return this;
    }

    public TrendingPage insertLanguage(String lang) {
        languageFilterInput.sendKeys(lang + Keys.ENTER);
        return this;
    }
    public List<String> getTenRepos() {
        return wait
                .until(ExpectedConditions.visibilityOfAllElements(trendingRepos)).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

}
