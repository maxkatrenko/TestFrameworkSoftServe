package lesson1;

import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleTestNG1 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Child1");
    }

    @BeforeGroups("academy")
    public void beforeGroup() {
        System.out.println("Before Group");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Child1");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method Child1");
    }

    @Test
    public void testA() {
        System.out.println("testA");
        Assert.assertEquals(true, true);
    }

    @Test
    public void testB() {
        System.out.println("testB");
        Assert.assertEquals(true, true);
    }

    @Test(groups = "academy")
    public void testC() {
        System.out.println("testC");
        Assert.assertEquals(true, true);
    }

    @Test
    public void testD() {
        System.out.println("testD");
        Assert.assertEquals(true, true);
    }
}
