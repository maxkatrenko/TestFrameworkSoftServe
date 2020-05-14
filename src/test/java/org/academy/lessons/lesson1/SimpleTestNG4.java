package org.academy.lessons.lesson1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTestNG4 {

    @DataProvider(name = "provider-test")
    public Object[][] dataProviderTest() {
        return new Object[][] {
                {"first sum", 5, 5},
                {"second sum", 1, 2},
                {"third sum", 3, 4}
        };
    }

    @Test(dataProvider = "provider-test")
    public void testDataProvider(String name, int num1, int num2) {
        System.out.println(name + " " + (num1 + num2));
    }
}
