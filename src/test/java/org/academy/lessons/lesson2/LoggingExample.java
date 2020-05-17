package org.academy.lessons.lesson2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingExample {
    public static void main(String[] args) {
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
    }
}
