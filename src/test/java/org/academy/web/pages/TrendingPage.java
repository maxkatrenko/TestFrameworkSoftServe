package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;



public class TrendingPage extends AbstractPage {

    public TrendingPage(WebDriver webDriver) {
        super(webDriver, false);
    }
    @FindBy(xpath = "//div[@class='mb-3 mb-sm-0']//span[@class='text-bold']")
    private WebElement dropDownLanguage;

    @FindBy(xpath = "//details[@id='select-menu-language']//a[3]//*[contains(text(),'Java')]")
    private WebElement javaLanguage;

    @FindBy(xpath = "//details[@id='select-menu-date']//summary//span")
    private WebElement dropDownDateRange;

    @FindBy(xpath = "//span[contains(text(),'This week')]")
    private WebElement thisMonthDateRange;

    public TrendingPage clickOndropDownLanguage() {
        dropDownLanguage.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOnJavaLanguage() {
        javaLanguage.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOndropDownDateRange() {
        dropDownDateRange.click();
        return new TrendingPage(webDriver);
    }
    public TrendingPage clickOnThisMonth() {
        thisMonthDateRange.click();
        return new TrendingPage(webDriver);
    }


    public TrendingPage(WebDriver webDriver, boolean navigateToPage, String navigateToPageUrl) {
        super(webDriver, navigateToPage, navigateToPageUrl);
    }


    @FindBy(xpath = "//*[@href=\"/trending?spoken_language_code=en\"]")
    private WebElement englishSection;

    @FindBy(xpath = "//summary[@class=\"btn-link select-menu-button\"]")
    private List<WebElement> allFilters;

    @FindBy(xpath = "//a[@href='https://github.com/trending/java?since=monthly&spoken_language_code=en']")
    private WebElement thisMonthTimeSpan;

    @FindBy(xpath = "//h1[@class='h3 lh-condensed']")
    private List<WebElement> trendingRepos;

    @FindBy(xpath = "//span[contains(text(), 'Russian')]")
    private WebElement russianLangSection;

    @FindBy(xpath = "//span[contains(text(), 'Arabic')]")
    private WebElement arabicLangSection;

    @FindBy(xpath = "//span[contains(text(), 'month')]")
    private WebElement monthDateSection;

    @FindBy(xpath = "//a[@href=\"/trending/java?since=daily&spoken_language_code=en\"]")
    private List<WebElement> javaLangSection;

    @FindBy(id = "text-filter-field-spoken-language")
    private WebElement spokeLanguageInput;

    @FindBy(xpath = "//h3")
    private WebElement messagesAboutRepos;

    public TrendingPage insertInSpokeInput(String lang){
       spokeLanguageInput.sendKeys(lang);
        return this;
    }

    public TrendingPage clickOnSpokenLanguageTab(){
        allFilters.get(0).click();
        return this;
    }

    public TrendingPage selectEnglishLanguage(){
        englishSection.click();
        return this;
    }

    public TrendingPage selectRussianLanguage(){
        russianLangSection.click();
        return this;
    }

    public TrendingPage selectArabianLanguage(){
        arabicLangSection.click();
        return this;
    }
    public TrendingPage selectMonthDateRange(){
        monthDateSection.click();
        return this;
    }

    public TrendingPage clickOnLanguageTab(){
        allFilters.get(1).click();
        return this;
    }
    public TrendingPage clickOnDateRangeTab(){
        allFilters.get(2).click();
        return this;
    }

    public TrendingPage selectJavaLang(){
        javaLangSection.get(0).click();
        return this;
    }

    public List<String> getTenRepos() {
        return trendingRepos.stream()
                .map(WebElement::getText).limit(10).collect(Collectors.toList());
    }
    public int countRusRepos(){
        if(trendingRepos.size() != 0){
            return trendingRepos.size();
        }
        return 0;
    }
    public int countArabRepos(){
        if((messagesAboutRepos.getText()).equals("It looks like we don’t have any trending repositories for Java.")){
            return 0;
        }
        return trendingRepos.size();
    }


}
