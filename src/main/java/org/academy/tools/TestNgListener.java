package org.academy.tools;

import org.testng.*;

public class TestNgListener extends TestListenerAdapter implements IInvokedMethodListener, IClassListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("On Start Listener");
    }

    @Override
    public void onBeforeClass(ITestClass itestClass) {
        System.out.println("On Before Class Listener");
    }
}
