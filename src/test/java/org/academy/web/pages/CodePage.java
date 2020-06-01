package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodePage extends AbstractPage {
    public CodePage(WebDriver webDriver) {
        super(webDriver, false, "");
    }

    @FindBy(xpath = "//input[@id='tree-finder-field']")
    private WebElement searchFileField;
    @FindBy(xpath="//span[@class='d-inline-block css-truncate-target js-tree-browser-result-path']")
    private WebElement fileProperties;
    @FindBy(xpath="//div[contains(@class,'application-main')]//div[3]")
    private WebElement fileContent;
    @FindBy(xpath = "//span[contains(text(),'Issues')]")
    private WebElement issuesLinkInRepo;

    public CodePage fillNameFile(String file){
        searchFileField.sendKeys(file);
        return new CodePage(webDriver);
    }
    public CodePage clickOnFile(){
        fileProperties.click();
        return new CodePage(webDriver);
    }
    public IssuesInRepoPage clickOnIssuesInRepo() {
        issuesLinkInRepo.click();
        return new IssuesInRepoPage(webDriver);
    }

    public String getFileContent() {
    return fileContent.getText();
}


}
