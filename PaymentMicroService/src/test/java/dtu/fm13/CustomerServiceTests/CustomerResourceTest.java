package dtu.fm13.CustomerServiceTests;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class CustomerResourceTest {
    @Test
    void testPersonEndpoint() {
        given()
          .when().get("/payments2")
          .then()
             .statusCode(200);
    }

}
