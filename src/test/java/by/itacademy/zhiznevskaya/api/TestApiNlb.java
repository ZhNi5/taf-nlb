package by.itacademy.zhiznevskaya.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestApiNlb {
    protected static final Logger logger = Logger.getLogger(TestApiNlb.class.getName());
    @Test
    public void athorizationErrorLoginNullTest() {

        ExtractableResponse body = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=null&password=1234&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .extract();
        String bodyString = body.asString();
        JsonObject jsonParserString = JsonParser.parseString(bodyString).getAsJsonObject();
        String result = jsonParserString.get("error").getAsJsonObject().get("message").getAsString();
        logger.info("athorizationErrorLoginNullTest passed with the result " +result );

    }

    @Test
    public void athorizationErrorPasswordNullTest() {

        ExtractableResponse body =  given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=NikaZhiznevskaya&password=null&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .extract();
        String bodyString = body.asString();
        JsonObject jsonParserString = JsonParser.parseString(bodyString).getAsJsonObject();
        String result = jsonParserString.get("error").getAsJsonObject().get("message").getAsString();
        logger.info("athorizationErrorPasswordNullTest passed with the result"+ result);

    }

    @Test
    public void athorizationErrorLoginNullPasswordNullTest() {

        ExtractableResponse body=given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=null&password=null&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .assertThat().body("error.type", equalTo("ERROR"))
                .extract();
        String bodyString = body.asString();
        JsonObject jsonParserString = JsonParser.parseString(bodyString).getAsJsonObject();
        String result = jsonParserString.get("error").getAsJsonObject().get("message").getAsString();
        logger.info("athorizationErrorLoginNullPasswordNullTest passed with the result"+result);

    }

    @Test
    public void athorizationLoginCorrectPasswordCorrectTest() {

        ExtractableResponse body =  given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("login=NikaZhiznevskaya&password=AlexNika5&processLogin=Login")
                .when()
                .post("https://www.nlb.by/oauth2/web/login")
                .then().statusCode(200)
                .extract();
        String bodyString = body.asString();
        JsonObject jsonParserString = JsonParser.parseString(bodyString).getAsJsonObject();
        String result = jsonParserString.get("success_auth").getAsString();
        logger.info(" athorizationLoginCorrectPasswordCorrectTest passed with the result "+result );
    }
}
