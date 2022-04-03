package com.it_academy.tests.onliner;


import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.listeners.AllureListener;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureListener.class)
public class BaseTest {

    @BeforeAll
    public void setUp() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }

}
