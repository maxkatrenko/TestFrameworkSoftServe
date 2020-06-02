package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TrafficPage extends AbstractPage {
    public TrafficPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//div[contains(@class,'col-6 top-content boxed-group')]//td[2]")
    private List<WebElement> popularContentViews;

    @FindBy(xpath = "//div[contains(@class,'col-6 top-content boxed-group')]//tr[1]//td[2]")
    private List<WebElement> firstContentViews;

    public List<Integer> getAllContentViews() {
        List<Integer> res = new ArrayList<>();
        for (WebElement trafficView : popularContentViews) {
            res.add(Integer.valueOf(trafficView.getText().replaceAll(",", "")));
        }
        return res;
    }

    public List<Integer> getFirstContentViews() {
        List<Integer> res = new ArrayList<>();
        for (WebElement trafficView : firstContentViews) {
            res.add(Integer.valueOf(trafficView.getText().replaceAll(",", "")));
        }
        return res;
    }
}
