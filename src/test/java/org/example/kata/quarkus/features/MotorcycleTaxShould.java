package org.example.kata.quarkus.features;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.example.kata.quarkus.infrastructure.builder.MotorcycleBuilder.aMotorCycle;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class MotorcycleTaxShould {

    @DisplayName("Return expected GBP When Motorcycle co2 has a value")
    @ParameterizedTest
    @CsvSource({
            "0,15"
    })
    public void return_expected_GBP_when_motorcycle_co2 (int co2, int expected) {
                given()
                .body(aMotorCycle().co2(co2).build(), ObjectMapperType.JACKSON_2)
                .contentType(ContentType.JSON)
                .when()
                .get("/taxVehicule/motorcycle")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));
    }
}
