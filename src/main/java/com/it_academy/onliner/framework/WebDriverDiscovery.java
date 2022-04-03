package com.it_academy.onliner.framework;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;


public class WebDriverDiscovery implements WebDriverProvider {
    private static final Logger LOG = LoggerFactory.getLogger(WebDriverCreator.class);

    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities capabilities) {

        try {
            String driverType = System.getProperty("driverType");
            LOG.info("Get the driver type");
            return DriverCreatorFactory.getDriverCreator(driverType).create();
        } catch (Exception e) {
            LOG.info("Driver type unknown");
        }
        return null;
    }
}