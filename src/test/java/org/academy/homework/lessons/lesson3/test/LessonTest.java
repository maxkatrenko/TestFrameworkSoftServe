package org.academy.homework.lessons.lesson3.test;

import lombok.extern.slf4j.Slf4j;
import org.academy.homework.lessons.lesson3.config.MainConfigLesson;
import org.academy.homework.lessons.lesson3.page.LoginPage;
import org.academy.homework.lessons.lesson3.page.MainPage;
import org.academy.web.AbstractWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class LessonTest extends AbstractWebDriver {

    public LessonTest() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        MainPage mainPage = new MainPage(webDriver, true, MainConfigLesson.getUrl());
        LoginPage loginPage = mainPage.clickOnSignIn();
        loginPage.enterUsername(MainConfigLesson.getUsername());
        loginPage.enterPassword(MainConfigLesson.getPassword());
        loginPage.clickOnSubmit();
    }

    @Test
    public void test() {
        log.info("done");
    }

}
