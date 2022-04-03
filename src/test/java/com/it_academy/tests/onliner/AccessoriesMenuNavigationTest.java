package com.it_academy.tests.onliner;

import com.it_academy.onliner.pageobject.BasePage;
import com.it_academy.onliner.pageobject.CatalogOnlinerPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccessoriesMenuNavigationTest extends BaseTest {

    @Test
    @Description("test the user is able to saw product sections of Catalog")
    public void testUserIsAbleToSawProductsSectionsOfCatalog() {
        new OnlinerHomePage().navigateToOnlinerHomePage();
        List<String> productsTitlesOfSectioinsAccessories = new OnlinerHomePage()
                .clickOnMainNavigationLink()
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .clickOnComputerAndNetworkClassifierLink("Комплектующие")
                .isNotEmptyProductListSectionsAccessoriesTitle();
        System.out.println(productsTitlesOfSectioinsAccessories);
        List<String> productsDescriptionsOfSectioinsAccessories = new CatalogOnlinerPage()
                .isNotEmptyProductListSectioinsAccessoriesDescriptions();
        System.out.println(productsDescriptionsOfSectioinsAccessories);
    }

}
