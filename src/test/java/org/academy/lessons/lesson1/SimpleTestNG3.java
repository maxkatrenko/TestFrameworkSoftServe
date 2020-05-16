package org.academy.lessons.lesson1;

import org.testng.annotations.Listeners;
import org.academy.tools.TestNgListener;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class SimpleTestNG3 {
    @Test
    public void testListener() {
        System.out.println("Verify Listener TestNg");
    }
}
