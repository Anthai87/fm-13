package dtu.RedGreenRefactor.main.model;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class CustomerResourceTest {
    @Test
    void testPersonEndpoint() {
        given()
          .when().get("/customer")
          .then()
             .statusCode(200);
    }

}
