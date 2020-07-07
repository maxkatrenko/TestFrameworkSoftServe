package org.academy.web.pages;

import org.academy.utils.web.WebWaiters;
import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RelatedCommitPage extends AbstractPage {

    @FindBy(xpath = "(//div[class='text-right'])[1]")
    private WebElement shortShaLink;

    public RelatedCommitPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    public CommitPage goToTestFileCommitPage() {
        WebWaiters.waitUntilElementIsClickable(webDriver, shortShaLink);
        shortShaLink.click();
        return new CommitPage(webDriver);
    }
}
