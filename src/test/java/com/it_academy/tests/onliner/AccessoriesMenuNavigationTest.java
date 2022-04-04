package com.it_academy.tests.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import com.it_academy.onliner.pageobject.CatalogOnlinerPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;



public class AccessoriesMenuNavigationTest extends BaseTest {

    @Test
    @Description("test the user is able to saw product sections of Catalog")
    public void testUserIsAbleToSawProductsSectionsOfCatalog() {
        new OnlinerHomePage().navigateToOnlinerHomePage()
                .clickOnMainNavigationLink()
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnComputerAndNetworkClassifierLink("Комплектующие")
                .assertProductListSectionsAccessoriesTitles();
        new CatalogOnlinerPage().assertProductListSectioinsAccessoriesDescriptions();
    }

}
