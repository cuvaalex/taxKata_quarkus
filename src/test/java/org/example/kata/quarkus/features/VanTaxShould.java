package org.example.kata.quarkus.features;


import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.kata.quarkus.domain.vehicules.Van;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class VanTaxShould {


    public static final String TAX_VEHICULE_PATH = "/taxVehicule/{type}";
    public static final String VEHICLE = "vehicle";
    public static final String TYPE = "type";
    public static final String TYPE_VAN = "van";


    @Test
    public void return_165GB_when_weight_less_equal_3500kg() {
        int expected = 165;
        given()
                .body(new Van(3500), ObjectMapperType.JACKSON_2)
                .pathParam(TYPE, TYPE_VAN)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                    .get(TAX_VEHICULE_PATH)
                .then()
                    .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));
    }

    @Test
    public void return_190GBP_when_weight_greater_than_3500kg() {
        int expected = 190;
        given()
                .body(new Van(3600), ObjectMapperType.JACKSON_2)
                .pathParam(TYPE, TYPE_VAN)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                    .get(TAX_VEHICULE_PATH)
                .then()
                    .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));

    }
}
