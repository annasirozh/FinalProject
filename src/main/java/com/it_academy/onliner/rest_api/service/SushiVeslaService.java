package com.it_academy.onliner.rest_api.service;

import com.it_academy.onliner.rest_api.model.SushiVeslaFacet;
import com.it_academy.onliner.rest_api.model.SushiVeslaRollsFacet;
import com.it_academy.onliner.rest_api.utils.GetRequestUtils;
import com.it_academy.onliner.rest_api.utils.ResponseBodyUtils;
import io.restassured.response.ResponseBody;
import java.util.List;
import java.util.Map;

public class SushiVeslaService {
    public List<SushiVeslaFacet> getNameOfSushiVeslaProducts() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        System.out.printf("Response body: {}", responseBody.asString());
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
                SushiVeslaFacet.class);
    }
    public List<SushiVeslaRollsFacet> getNameOfSushiVeslaRollsProducts() {
        String endpoint = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla?sushi_typ[0]=roll&sushi_typ[operation]=union";
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        System.out.printf("Response body: {}", responseBody.asString());
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
                SushiVeslaRollsFacet.class);
    }

    private Map<String, Object> configureRequestHeaders() {
        return Map.of("", "",
                "", "",
                "", "",
                "", "",
                "", "");
    }
}
