package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpBeanTests {

    // Запрос авторизации
    @Test
    void checkValidBasicAyth(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .auth().basic("123", "123")
                .get("http://httpbin.org/basic-auth/123/123");
        Assertions.assertEquals(200, response.statusCode());
    }

    // Проверка на невалидный пароль
    @Test
    void checkInvalidBasicAyth(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .auth().basic("555", "123")
                .get("http://httpbin.org/basic-auth/123/123");
        Assertions.assertEquals(401, response.statusCode());
    }

    // Запрос авторизации
    @Test
    void checkValidBearerAyth(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .header("Authorization", "Bearer 123")
                .get("http://httpbin.org/bearer");
        Assertions.assertEquals(200, response.statusCode());
    }

    // Запрос авторизации
    @Test
    void checkInValidBearerAyth(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .header("Authorization", "Bearer")
                .get("http://httpbin.org/bearer");
        Assertions.assertEquals(401, response.statusCode());
    }
}
