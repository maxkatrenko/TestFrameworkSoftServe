package org.academy.web.pages;

import org.academy.MainConfig;
import org.academy.web.AbstractPage;
import org.academy.web.WebWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectTabPage extends AbstractPage {
    public ProjectTabPage(WebDriver webDriver){super(webDriver, false);
    }


    private WebElement firstProjectLink = webDriver.findElement(By.linkText(MainConfig.getParam("project")));

    public KanbanBoardPage goToFirstProject(){
        WebWaiters.waitUntilElementIsClickable(webDriver, firstProjectLink);
        firstProjectLink.click();
        return new KanbanBoardPage(webDriver);
    }
}
