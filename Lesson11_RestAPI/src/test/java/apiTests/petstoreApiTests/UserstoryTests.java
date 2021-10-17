package apiTests.petstoreApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import petstore.User;

public class UserstoryTests {
    // Запрос авторизации
    @Test
    void checkContentTypeInResponse(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .header("Accept", "application/xml")
                .get("https://petstore.swagger.io/v2/user/user1");
        Assertions.assertEquals("application/xml", response.contentType());
    }

    // Создание пользователя с подтверждением, что ответ не пуст
    @Test
    void createUserTest(){
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .body("{\"username\":\"testUser555\"}")
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/user");
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertFalse(response.getBody().asString().isEmpty());
    }

    /*@Test
    void getUserTest(){
        Response response = (Response) RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/user/user1").as(User.class);
        System.out.println(response.toString());
    }*/
}
