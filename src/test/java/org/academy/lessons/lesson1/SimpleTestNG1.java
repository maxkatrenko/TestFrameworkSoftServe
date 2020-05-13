package org.academy.lessons.lesson1;

import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTestNG1 {
    @BeforeGroups("academy")
    public void beforeGroup() {
        System.out.println("Before Group");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Child1");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Child1");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("Before method Child1");
    }

    @Test
    public void testA1() {
        System.out.println("testA1");
        Assert.assertEquals(true, true);
    }

    @Test
    public void testB1() {
        System.out.println("testB1");
        Assert.assertEquals(true, true);
    }

    @Test(groups = "academy")
    public void testC1() {
        System.out.println("testC1");
        Assert.assertEquals(true, true);
    }

    @Test
    public void testD1() {
        System.out.println("testD1");
        Assert.assertEquals(true, true);
    }
}
