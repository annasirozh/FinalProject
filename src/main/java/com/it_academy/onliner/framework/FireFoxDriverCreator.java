package com.it_academy.onliner.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFoxDriverCreator implements WebDriverCreator<RemoteWebDriver> {
    @Override
    public RemoteWebDriver create() {return new FirefoxDriver();}
}
