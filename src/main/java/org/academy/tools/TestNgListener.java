package org.academy.tools;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestNgListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Testcase passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Testcase failed: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " test case started");
    }
}
