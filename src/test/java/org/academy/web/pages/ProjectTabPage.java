package org.academy.web.pages;

import org.academy.TestConfigurations;
import org.academy.utils.web.WebWaiters;
import org.academy.web.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTabPage extends AbstractPage {
    private final WebElement firstProjectLink = webDriver.findElement(By.linkText(TestConfigurations.getParam("project")));


    public ProjectTabPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    public KanbanBoardPage goToFirstProject() {
        WebWaiters.waitUntilElementIsClickable(webDriver, firstProjectLink);
        firstProjectLink.click();
        return new KanbanBoardPage(webDriver);
    }
}
