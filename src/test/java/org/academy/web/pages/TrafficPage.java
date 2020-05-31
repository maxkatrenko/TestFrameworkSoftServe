package org.academy.web.pages;

import org.academy.web.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrafficPage extends AbstractPage {
    public TrafficPage(WebDriver webDriver) {
        super(webDriver, false);
    }

    @FindBy(xpath = "//div[contains(@class,'col-6 top-content boxed-group')]//td[2]")
    private List<WebElement> trafficViews;

    @FindBy(xpath = "//div[contains(@class,'col-6 top-content boxed-group')]//tr[1]//td[2]")
    private List<WebElement> aloch;

    public List<String> getAllContentViews() {
        List<String> res = new ArrayList<>();
        for (WebElement trafficView : trafficViews) {
            res.add(trafficView.getText());
        }
        return res;
    }

    public List<String> getFirstContentViews() {
        List<String> res = new ArrayList<>();
        for (WebElement trafficView : aloch) {
            res.add(trafficView.getText());
        }
        return res;
    }

    public List<Integer> convertToInteger(List<String> res) {
        List<Integer> result = new ArrayList<>();
                result= res.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
        return result;
    }
}
