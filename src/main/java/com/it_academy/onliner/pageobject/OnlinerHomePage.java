package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;
import static com.it_academy.onliner.enums.OnlinerPageUrls.HOME_PAGE;

public class OnlinerHomePage extends BasePage{
    private SelenideElement catalogLink =
            $x("//*[contains(@class, 'main-navigation__text') and contains(text(), 'Каталог')]");

   @Step("Open the browser")
   public OnlinerHomePage navigateToOnlinerHomePage() {
       open(HOME_PAGE.getUrl());
       return this;
   }

   @Step("Click on catalog classifier link {link}")
   public CatalogOnlinerPage clickOnMainNavigationLink() {
        catalogLink.shouldBe(visible, ofSeconds(20)).click();
        return new CatalogOnlinerPage();
    }
}