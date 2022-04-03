package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogOnlinerPage extends BasePage {
    private ElementsCollection catalog_list_title_menu_sections =
            $$x( "//*[@class='catalog-navigation-classifier__item-title'] //*[normalize-space(text())]");
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier__item ')]//*[contains(text(), '%s')]";
    private ElementsCollection category_menu_sections_title =
            $$x("//*[@class='catalog-navigation-list__category' and @data-id='2']//*[@class='catalog-navigation-list__aside-item']//*[@class='catalog-navigation-list__aside-title']");
    private static final String CATEGORY_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private ElementsCollection product_title_list =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]//following-sibling::div[@class='catalog-navigation-list__dropdown']//a//*[contains(@class, 'title')]");
    private ElementsCollection product_description_title_list =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]//following-sibling::div[@class='catalog-navigation-list__dropdown']//a//*[contains(@class, 'description')and contains(text(),'товар')]");

    @Step("Verify that the catalog menu exists")
    public List<String>isNotEmptyCatalogMenuSectionsTitle(){
        List<String> catalogElementsTitles = new ArrayList<>();
        catalog_list_title_menu_sections.shouldHave(sizeGreaterThan(0));
        catalog_list_title_menu_sections.shouldHave(allMatch("catalog menu sections is not empty", element->!element.getText().isEmpty()));
        catalog_list_title_menu_sections.texts().forEach(catalogElementsTitles::add);
        return catalogElementsTitles;
    }
    @Step("Select category {category}")
    public CatalogOnlinerPage clickOnCatalogClassifierLink(String link){
        $x(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN,link))
                .shouldBe(visible).click();
        return this;
    }

    @Step("Getting a list of category menu items")
    public List<String> getCategoryMenuSectionsTitle() {
        List<String> categoryElementsTitles = new ArrayList<>();
        category_menu_sections_title.shouldHave(sizeGreaterThan(0));
        category_menu_sections_title.shouldHave(allMatch("category elements menu sections is not empty",element->!element.getText().isEmpty()));
        category_menu_sections_title.texts().forEach(categoryElementsTitles::add);
        return categoryElementsTitles;
    }

    @Step("Select product {product}")
    public CatalogOnlinerPage clickOnComputerAndNetworkClassifierLink(String link){
        $x(String.format(CATEGORY_CLASSIFIER_LINK_XPATH_PATTERN,link))
                .shouldBe(visible).click();
        return this;
    }

    @Step("Checking Product Headers Are Not Empty")
    public List<String> isNotEmptyProductListSectionsAccessoriesTitle(){
        List<String> productElementsTitles = new ArrayList<>();
        product_title_list.shouldHave(sizeGreaterThan(0));
        product_title_list.shouldHave(allMatch("product list sections is not empty", element->!element.getText().isEmpty()));
        product_title_list.texts().forEach(productElementsTitles::add);
        return productElementsTitles;
    }
    @Step("Checking that each product has a price")
    public List<String> isNotEmptyProductListSectioinsAccessoriesDescriptions(){
        List<String> productElementsTitles = new ArrayList<>();
        product_description_title_list.shouldHave(sizeGreaterThan(0));
        product_description_title_list.shouldHave(allMatch("product list sections is not empty", element->!element.getText().isEmpty()));
        product_description_title_list.texts().forEach(productElementsTitles::add);
        return productElementsTitles;
    }
}
