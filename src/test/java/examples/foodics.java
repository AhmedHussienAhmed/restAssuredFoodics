package examples;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class foodics {
    String email = "merchant@foodics.com";
    String password = "123456";
    String token = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";

    String userId = "1deb74be-77fa-4eec-8980-de3116f37251";
    String userName = "Test Foodics";

    @Test
    public void loginSuccessfullyToFoodicsWebsite() {


        given()
                .contentType(ContentType.JSON)
                .body("{\r\n\"email\": \"" + email + "\",\r\n\"password\": \"" + password + "\",\r\n\"token\": \"" + token + "\"}")
                .when()
                .post("https://pay2.foodics.dev/cp_internal/login")
                .then()
                .assertThat()
                .statusCode(200) // Assuming a successful login returns a 200 status code
                .body("token", notNullValue()) //Asset that token not Null
                .log().body();
    }

    @Test
    public void checkWhomiUserResponseId() {
        Response response= given()
                .contentType(ContentType.JSON)
                .body("{\r\n\"email\": \"" + email + "\",\r\n\"password\": \"" + password + "\",\r\n\"token\": \"" + token + "\"}")
                .when()
                .post("https://pay2.foodics.dev/cp_internal/login")
                .then()
                .assertThat()
                .body("token", notNullValue()) //Asserting on token that it is not empty
                .statusCode(200).extract().response(); // Assuming a successful login returns a 200 status code
                String token = response.jsonPath().get("token");


        given().header("Authorization", "Bearer " + token)
                .when()
                .get("https://pay2.foodics.dev/cp_internal/whoami")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user.'id'", notNullValue())
                .body("user.'id'",equalTo(userId));
    }

    @Test
    public void checkWhomiUserResponseUserName() {
        Response response= given()
                .contentType(ContentType.JSON)
                .body("{\r\n\"email\": \"" + email + "\",\r\n\"password\": \"" + password + "\",\r\n\"token\": \"" + token + "\"}")
                .when()
                .post("https://pay2.foodics.dev/cp_internal/login")
                .then()
                .assertThat()
                .body("token", notNullValue()) //Asserting on token that it is not empty
                .statusCode(200).extract().response(); // Assuming a successful login returns a 200 status code
        String token = response.jsonPath().get("token");

        given().header("Authorization", "Bearer " + token).when()
                .get("https://pay2.foodics.dev/cp_internal/whoami")
                .then()
                .assertThat()
                .statusCode(200)
                .body("user.'name'", equalTo(userName));
    }
}
