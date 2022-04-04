package com.it_academy.listeners;

import com.it_academy.tests.utils.ScreenShotsUtils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.extension.TestWatcher;


public class AllureListener implements TestWatcher {
    private static final Logger LOG = LoggerFactory.getLogger(AllureListener.class);

    public void testFailed(ExtensionContext context, Throwable cause) {
        LOG.error("Test failed for test {}", context.getDisplayName());
        ScreenShotsUtils.takeScreenshotAndAttachToAllureReport();
    }

    public void testAborted(ExtensionContext context, Throwable cause) {
        LOG.error("Test aborted for test {}", context.getDisplayName());
        ScreenShotsUtils.takeScreenshotAndAttachToAllureReport();
    }
}
