package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.onliner.framework.WebDriverDiscovery;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public abstract class BasePage {

    public BasePage() {
        Configuration.browser = WebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 20000;
        Configuration.startMaximized = true;
    }

    public void clickOnElementViaJs(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }
}
