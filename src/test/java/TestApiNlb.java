import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApiNlb {
    protected static final Logger logger = LogManager.getLogger();

    @Test
    public void athorizationErrorLoginNullTest() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=null&password=1234&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .log().body();
        logger.info("athorizationErrorLoginNullTest passed with the result");

    }

    @Test
    public void athorizationErrorPasswordNullTest() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=NikaZhiznevskaya&password=null&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .log().body();
        logger.info("athorizationErrorPasswordNullTest passed with the result");

    }

    @Test
    public void athorizationErrorLoginNullPasswordNullTest() {

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=null&password=null&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .log().body();
        logger.info("athorizationErrorLoginNullPasswordNullTest passed with the result");

    }

    @Test
    public void athorizationLoginCorrectPasswordCorrectTest() {

        ValidatableResponse body = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=NikaZhiznevskaya&password=AlexNika5&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200);
        //.assertThat().body("success_auth",equalTo("true"));
        Response response = body.extract().response();
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
        logger.info(" athorizationLoginCorrectPasswordCorrectTest passed with the result " + response.getStatusLine());
    }
}
