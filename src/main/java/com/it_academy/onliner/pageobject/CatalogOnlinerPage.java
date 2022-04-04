package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogOnlinerPage extends BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogOnlinerPage.class);
    private ElementsCollection catalogListTitleMenuSections =
            $$x("//*[@class='catalog-navigation-classifier__item-title'] //*[normalize-space(text())]");
    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier__item ')]//*[contains(text(), '%s')]";
    private ElementsCollection categoryMenuSectionsTitles =
            $$x("//*[@class='catalog-navigation-list__category' and @data-id='2']//*[@class='catalog-navigation-list__aside-item']//*[@class='catalog-navigation-list__aside-title']");
    private static final String CATEGORY_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private ElementsCollection productTitles =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]//following-sibling::div[@class='catalog-navigation-list__dropdown']//a//*[contains(@class, 'title')]");
    private ElementsCollection productDescriptionTitlee =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') and not (contains(text(), 'Комплектующие для'))]//following-sibling::div[@class='catalog-navigation-list__dropdown']//a//*[contains(@class, 'description')and contains(text(),'товар')]");

    @Step("Verify that the catalog menu exists")
    public void assertCatalogMenuSectionsTitle() {
        LOG.info("Get the text of the catalog menu list", catalogListTitleMenuSections.texts());
        catalogListTitleMenuSections.shouldHave(sizeGreaterThan(0)).
                shouldHave(allMatch("catalog menu sections is not empty",
                        element -> !element.getText().isEmpty()));
    }

    @Step("Select category {category}")
    public CatalogOnlinerPage clickOnCatalogClassifierLink(String link) {
        $x(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible).click();
        return this;
    }

    @Step("Getting a list of category menu items")
    public List<String> getCategoryMenuSectionsTitles() {
        LOG.info("Get text menu category of catalog");
        categoryMenuSectionsTitles.shouldHave(sizeGreaterThan(0))
                .shouldHave(allMatch("category elements menu sections is not empty",
                        element -> !element.getText().isEmpty()));
        return categoryMenuSectionsTitles.texts();
    }

    @Step("Select product {product}")
    public CatalogOnlinerPage clickOnComputerAndNetworkClassifierLink(String link) {
        $x(String.format(CATEGORY_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible).click();
        return this;
    }

    @Step("Checking Product Headers Are Not Empty")
    public void assertProductListSectionsAccessoriesTitles() {
        LOG.info("Get text product list sections accessories", productTitles.texts());
        productTitles.shouldHave(sizeGreaterThan(0))
                .shouldHave(allMatch("product list sections is not empty",
                        element -> !element.getText().isEmpty()));

    }

    @Step("Checking that each product has a price")
    public void assertProductListSectioinsAccessoriesDescriptions() {
        LOG.info("Get text descriptions product list sections accessories",
                productDescriptionTitlee.texts());
        productDescriptionTitlee.shouldHave(sizeGreaterThan(0))
                .shouldHave(allMatch("product list sections is not empty",
                        element -> !element.getText().isEmpty()));
    }
}
