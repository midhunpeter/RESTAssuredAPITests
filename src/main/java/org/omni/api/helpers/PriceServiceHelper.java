package org.omni.api.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.omni.api.constants.EndPoints;
import org.omni.api.model.Price;
import org.omni.api.utilities.ConfigManager;

import java.lang.reflect.Type;
import java.util.List;

public class PriceServiceHelper {
    private static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public PriceServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();

    }

    public List<Price> getPrice() {

        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_PRICE)
                .andReturn();

        Type type = new TypeReference<List<Price>>() {
        }.getType();
        List<Price> priceList = response.as(type);
        return priceList;
    }

}
