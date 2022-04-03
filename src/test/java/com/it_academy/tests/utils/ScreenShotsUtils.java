package com.it_academy.tests.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenShotsUtils {
    protected static final Logger LOG = LoggerFactory.getLogger(ScreenShotsUtils.class);

    public ScreenShotsUtils() {
    }

    public static void takeScreenshotAndAttachToAllureReport() {
        try {
            File screenshotAs = Screenshots.takeScreenShotAsFile();
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
            LOG.info("Screenshot is created");
        } catch (IOException e) {
            LOG.error("Error creating screenshot");
        }
    }

}
