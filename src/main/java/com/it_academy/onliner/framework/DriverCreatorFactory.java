package com.it_academy.onliner.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverCreatorFactory {

    public static WebDriverCreator getDriverCreator(String driverType){

        final Logger LOG = LoggerFactory.getLogger(WebDriverCreator.class);

        switch(driverType){
            case "chrome":
                LOG.info("Download Chromdriver");
                return new ChromeDriverCreator();
            case "firefox":
                LOG.info("Download FirefoxDriver");
                return new FireFoxDriverCreator();
            default:
                LOG.info("No driver selected, chromedriver is loaded by default");
                return new ChromeDriverCreator();
        }
    }

}
