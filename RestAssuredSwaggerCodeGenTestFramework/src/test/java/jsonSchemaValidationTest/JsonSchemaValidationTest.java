package jsonSchemaValidationTest;

//import com.github.fge.jsonschema.SchemaVersion;
//import com.github.fge.jsonschema.cfg.ValidationConfiguration;
//import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidationTest {
    @Test
    void validate(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("comments", "Pleease");
        jsonObject.addProperty("custemail", "top@mail.ru");
        jsonObject.addProperty("custname", "Ivanov Ivan");
        jsonObject.addProperty("custtel", "88003332255");
        jsonObject.addProperty("delivery", "12:45");
        jsonObject.addProperty("size", "medium");
        JsonArray toppings = new JsonArray();
        toppings.add("bacon");
        toppings.add("onion");
        toppings.add("mushroom");
        jsonObject.add("toppings", toppings);

        Response response= RestAssured
                .given()
                .log()
                .all()
                .body(jsonObject.toString())
                .post("http://httpbin.org/post");
        System.out.println(response.toString());
        //response.then().body(matchesJsonSchemaInClasspath("httpBeanJsonSchema.json").using(runJsonSchemaFactory()));

    }

    /*public JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }*/
}
