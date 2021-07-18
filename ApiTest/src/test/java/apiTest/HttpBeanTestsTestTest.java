package apiTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpBeanTestsTestTest {

    @Test
    void checkValidBasicAuth(){
        Response response = RestAssured
                .get()
                .log().all()
                .auth().basic("user", "123", "passwd","123")
                .get("http://httpbin.org/basic-auth");
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void checkInalidBasicAuth(){
        Response response = RestAssured
                .get()
                .log().all()
                .auth().basic("555", "123")
                .get("http://httpbin.org/basic-auth/123/123");
        Assertions.assertEquals(401, response.statusCode());
    }

}