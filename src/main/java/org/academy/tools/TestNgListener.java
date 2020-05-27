package org.academy.tools;

import org.testng.*;

public class TestNgListener extends TestListenerAdapter implements IInvokedMethodListener, IClassListener, ISuiteListener, ITestListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("On Start Listener");
    }

    @Override
    public void onBeforeClass(ITestClass itestClass) {
        System.out.println("On Before Class Listener");
    }

    @Override
    public void onTestSuccess(ITestResult success) {
        super.onTestSuccess(success);
        System.out.println("Test passed successfully!");
    }

    @Override
    public void onTestFailure(ITestResult failure) {
        super.onTestFailure(failure);
        System.out.println("Test failed!");
    }

    @Override
    public void onTestSkipped(ITestResult skipped) {
        super.onTestSkipped(skipped);
        System.out.println("Test skipped!");
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        System.out.println("Test starts");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        System.out.println("Test finished");
    }
}
