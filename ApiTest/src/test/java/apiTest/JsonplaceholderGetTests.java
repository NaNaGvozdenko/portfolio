package apiTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.StreamSupport;

public class JsonplaceholderGetTests {
    @Test
    void checkStatusCodeInPostsRequest(){
        Response response = RestAssured.get("http://jsonplaceholder.typicode.com/posts");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkStatusCodeInGetCommentsResponse(){
        Response response = ResrAssured
                .given()
                .baseUri("http://jsonplaceholder.typicode.com")
                .basePath("comments")
                .param("postId", "1")
                .get();
        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
    }

    // TODO add paramValue checking in response
    @Test
    void checkStatusCodeInGetCommentsResponse2(){
        String paramValue = "1";
        Response response = ResrAssured
                .given()
                .log().all()
                .baseUri("http://jsonplaceholder.typicode.com")
                .basePath("comments")
                .param("postId", "1")
                .get();
        //System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
        //Assertions.assertEquals(paramValue, "response.postId");
    }
}
