package org.example.kata.quarkus.features;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.kata.quarkus.domain.vehicules.Car;
import org.example.kata.quarkus.domain.vehicules.Van;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.ws.rs.core.MediaType;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class CarTaxShould {
    @DisplayName("Return 165 GBP When car register before 1st march 2001 and cc less or equal 1550")
    @Test
    public void return_165GBP_when_register_before_20010301_and_cc_less_equal_1550cc(){
        int expected = 165;
        given()
                .body(new Car(
                        LocalDateTime.of(2001, 1, 1, 0, 0),
                        1550, 0)
                        , ObjectMapperType.JACKSON_2)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .get("/taxVehicule/car")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));
    }

    @DisplayName("Return 190 GBP When car register before 1st march 2001 and cc greater than 1550")
    @Test
    public void return_165GBP_when_register_before_20010301_and_cc_greater_1550cc(){
        int expected = 190;
        given()
                .body(new Car(
                                LocalDateTime.of(2001, 1, 1, 0, 0),
                                1551, 0)
                        , ObjectMapperType.JACKSON_2)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .get("/taxVehicule/car")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));
    }

    @DisplayName("Return expected GBP When car register after or equal 1st march 2001 and co2")
    @ParameterizedTest
    @CsvSource({
        "0,65"
    })
    public void return_65GBP_when_register_after_equal_20010301_and_co2_up_to_100(int co2, int expected){
        given()
                .body(new Car(
                                LocalDateTime.of(2001, 1, 1, 0, 0),
                                0, co2)
                        , ObjectMapperType.JACKSON_2)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .get("/taxVehicule/car")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("tax", equalTo(expected));
    }


}
