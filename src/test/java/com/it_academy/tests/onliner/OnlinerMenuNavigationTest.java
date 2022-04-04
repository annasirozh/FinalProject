package com.it_academy.tests.onliner;

import com.it_academy.onliner.pageobject.CatalogOnlinerPage;
import com.it_academy.onliner.pageobject.OnlinerHomePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerMenuNavigationTest extends BaseTest {
    private static final List<String> CATEGORY_COMPUTER_AND_NETWORK_LIST =
            Arrays.asList("Ноутбуки, компьютеры, мониторы",
                    "Комплектующие", "Хранение данных", "Сетевое оборудование");

    @Test
    @Description("test the user is able to saw sections of Catalog")
    public void testUserIsAbleToSawSectionsOfCatalog() {
        new OnlinerHomePage().navigateToOnlinerHomePage()
                .clickOnMainNavigationLink()
                .assertCatalogMenuSectionsTitle();
    }

    @Test
    @Description("test the user is able to saw sections of Computer and Network menu sections")
    public void testUserIsAbleToSawSectionsOfComputerAndNetworkMenuSections() {
        new OnlinerHomePage().navigateToOnlinerHomePage();
        List<String> computerAndNetworksMenuSectioins = new OnlinerHomePage()
                .clickOnMainNavigationLink()
                .clickOnCatalogClassifierLink("Компьютеры и\u00a0сети")
                .getCategoryMenuSectionsTitles();
        assertThat(computerAndNetworksMenuSectioins)
                .as("Sections of menu and Networks is not displayed")
                .containsAll(CATEGORY_COMPUTER_AND_NETWORK_LIST);
    }

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
