package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabelsPage extends AbstractPage {
    public LabelsPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary js-details-target js-details-target-new-label')]")
    private WebElement newLabelBtn;

    @FindBy(xpath = "//input[@id='label-name-']")
    private WebElement labelName;

    @FindBy(xpath = "//input[@id='label-description-']")
    private WebElement labelDescription;

    @FindBy(xpath = "//input[@id='label-color-']")
    private WebElement labelColor;

    @FindBy(xpath = "//button[contains(text(),'Create label')]")
    private WebElement createBtn;

    @FindBy(xpath = "//span[@class='js-labels-count']")
    private WebElement count;

    String label = "//div/a/span[contains(text(),'" + MainConfig.getLabel() + "')]/following::*[11]";
    private WebElement deletebtn = webDriver.findElement(By.xpath(label));

//    private WebElement deletebtn = webDriver.findElement(By.xpath("//div/a/span[contains(text(),'test')]/following::*[11]"));

    public LabelsPage addNewLabel() {
        newLabelBtn.click();
        labelName.sendKeys(MainConfig.getLabel());
//        labelDescription.sendKeys();
//        labelColor.sendKeys();
        createBtn.click();
        return this;
    }

    public LabelsPage deleteLabel() {
        deletebtn.click();
        webDriver.switchTo().alert().accept();
        return this;
    }

    public int getLabelsAmount() {
        return Integer.parseInt(count.getText());
    }

}
