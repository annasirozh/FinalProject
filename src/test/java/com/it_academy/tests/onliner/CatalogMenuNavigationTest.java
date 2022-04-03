package com.it_academy.tests.onliner;

import com.it_academy.onliner.pageobject.CatalogOnlinerPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogMenuNavigationTest extends BaseTest{

    @Test
    @Description ("test the user is able to saw sections of Catalog")
    public void testUserIsAbleToSawSectionsOfCatalog() {
        new OnlinerHomePage().navigateToOnlinerHomePage();
        List<String> catalogMenuSections = new OnlinerHomePage()
                .clickOnMainNavigationLink()
                .isNotEmptyCatalogMenuSectionsTitle();
        System.out.println(catalogMenuSections);
    }
    @Test
    @Description("test the user is able to saw sections of Computer and Network menu sections")
    public void testUserIsAbleToSawSectionsOfComputerAndNetworkMenuSections() {
        new OnlinerHomePage().navigateToOnlinerHomePage();
        List<String> computerAndNetworksMenuSectioins  = new OnlinerHomePage()
                .clickOnMainNavigationLink()
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .getCategoryMenuSectionsTitle();
        assertThat(computerAndNetworksMenuSectioins)
                .as("Sections of menu and Networks is not displayed")
                .contains("Ноутбуки, компьютеры, мониторы","Комплектующие","Хранение данных","Сетевое оборудование");
        System.out.println(computerAndNetworksMenuSectioins );
    }
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
