package com.it_academy.tests.onliner.rest_api;

import com.it_academy.onliner.rest_api.model.SushiVeslaRollsFacet;
import com.it_academy.onliner.rest_api.service.SushiVeslaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SushiVeslaNavigationOfTypeRollsTest {

    @Test
    public void testUserIsChooseRolls() {
        SushiVeslaService sushiVeslaService = new SushiVeslaService();
        List<SushiVeslaRollsFacet> rollsSushiVesla = sushiVeslaService.getNameOfSushiVeslaRollsProducts();
        assertThat(rollsSushiVesla)
                .as("Name_prefix is not contains in the type of products")
                .allMatch(element -> element.getName_prefix().contains("Роллы"));
        rollsSushiVesla.forEach(System.out::println);
    }
}
