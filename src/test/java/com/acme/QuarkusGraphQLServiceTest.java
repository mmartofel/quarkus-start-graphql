package com.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class QuarkusGraphQLServiceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/")
          .then()
             .statusCode(200);
    }

}