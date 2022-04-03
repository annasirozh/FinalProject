package com.it_academy.tests.onliner.rest_api;

import com.it_academy.onliner.rest_api.model.SushiVeslaFacet;
import com.it_academy.onliner.rest_api.service.SushiVeslaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SushiVeslaNavigationTest {

    @Test
    public void testUserIsChooseNeedOfProduct() {
        SushiVeslaService sushiVeslaService = new SushiVeslaService();
        List<SushiVeslaFacet> productsSushiVesla = sushiVeslaService.getNameOfSushiVeslaProducts();
        assertThat(productsSushiVesla)
                .as("Name of rolls SushiVesla is not displayed")
                .allMatch(element -> element != null);
        productsSushiVesla.forEach(System.out::println);
    }
}
