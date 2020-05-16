package org.academy.chelpan.karyna.lessons3.pages;

import org.academy.chelpan.karyna.lessons3.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodePage extends AbstractPage{
    public CodePage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//input[@id='tree-finder-field']")
    private WebElement searchFileField;
    @FindBy(xpath ="//span[contains(text(),'Code')]")
    private WebElement codeLabel;
    @FindBy(xpath="//span[@class='d-inline-block css-truncate-target js-tree-browser-result-path']")
    private WebElement fileProperties;
    @FindBy(xpath="//div[contains(@class,'application-main')]//div[3]")
    private WebElement fileContent;

    public CodePage fillNameFile(String file){
        searchFileField.sendKeys(file);
        return new CodePage(webDriver);
    }
    public CodePage clickOnFile(){
        fileProperties.click();
        return new CodePage(webDriver);
    }

    public String getFileContent() {
    return fileContent.getText();
}
}
