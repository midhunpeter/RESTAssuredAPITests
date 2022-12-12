package org.omni.api.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.omni.api.constants.EndPoints;
import org.omni.api.model.Price;
import org.omni.api.utilities.ConfigManager;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PriceServiceHelper {


    private static final String BASEURL;

    static {
        try {
            BASEURL = ConfigManager.getInstance().getString("baseUrl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String PORT;

    static {
        try {
            PORT = ConfigManager.getInstance().getString("port");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PriceServiceHelper() {
        RestAssured.baseURI = BASEURL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation(); //we are relaxing the HTTP validation since we are running the service from our local. TO BE REMOVED in actual implementation

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
