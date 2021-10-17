package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonlpaceholderGetTests {

    // Проверка на получение ошибки статус код 200 - ресурс работает в соответствие ожиданиям
    @Test
    void checkStatusCodeInGetPostsResponse(){
        Response response = RestAssured.get("http://jsonplaceholder.typicode.com/posts");
        Assertions.assertEquals(200, response.statusCode());
    }
/*
    // Добавить проверку парам валуе из респонса
    @Test
    void checkStatusCodeInGetCommentsResponse(){
        String paramValue = "1";
        Response response = RestAssured
                .given()
                .baseUri("http://jsonplaceholder.typicode.com")
                .basePath("comments")
                .param("postId", paramValue)
                .get();
        new String(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(paramValue, "response.postId");
    }

    // Пример с отправкой нескольких параметров
    @Test
    void checkStatusCodeInGetCommentsResponseWithPostIdAndIdInParams(){
        String paramValue = "1";
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .baseUri("http://jsonplaceholder.typicode.com")
                .basePath("comments")
                .params("postId", paramValue, "id", 2)
                .get();
        new String(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        //Assertions.assertEquals(paramValue, "response.postId");
    }*/
}
