package apiTests.petstoreApiTests;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import petstore.*;

import java.util.List;

import static java.lang.System.*;

public class PetstoreTests {

    // Загрузка изображения питомца
    @Test
    void uploadsImagePet(){
        Image image = new Image();
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .body(image)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet/12/uploadImage");

        Assertions.assertFalse(response.getBody().asString().isEmpty());
    }

    // Создание домашнего питомца - успешно
    @Test
    void createPet(){
        Pet pet = new Pet();
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertFalse(response.getBody().asString().isEmpty());
    }

    // Обновление животного
    @Test
    void updateExistingPet(){
        Pet pet = new Pet();
        // создаем питомца
        RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");

        // обновляем его статус
        pet.setStatus("sold");

        // отправляем модель с измененным статусом для обновления
        Pet response = RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .put("https://petstore.swagger.io/v2/pet").as(Pet.class);

        Assertions.assertEquals("sold", response.getStatus());
    }

    // поиск животного по статусу
    @Test
    void findPetbyStatus(){
        Pet pet = new Pet("sold");
        // создаем питомца
        Response actualPet = RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");

        // ищем по статусу в списке созданных
        List<Pet> expectedPet = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status="+pet.getStatus()).as(new TypeRef<List<Pet>>() {});

        Assertions.assertEquals(expectedPet.get(0).getStatus(), pet.getStatus());
    }

    // Поиск животного по ID
    @Test
    void findPetbyID(){
        Pet pet = new Pet();
        // создаем питомца
        Response actualPet = RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");

        // get по ид
        Pet expectedPet = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://petstore.swagger.io/v2/pet/"+pet.getId()).as(Pet.class);

        Assertions.assertEquals(expectedPet.getId(), pet.getId());
    }

    // Удаление питомца, статус 200
    @Test
    void deletePet200(){
        Pet pet = new Pet();
        // создаем питомца
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");

        // удаляем
        Response responseDelete = RestAssured
                .given()
                .log().all() // логирование
                .body(new DeletePet(pet.getId()))
                .header("Content-Type", "application/json")
                .delete("https://petstore.swagger.io/v2/pet/"+pet.getId());

        Assertions.assertEquals(200, response.statusCode());
    }

    // Удаление питомца - 200 статус, поиск питомца по id - 404 статус "Pet not found"
    @Test
    void deletePet404(){
        Pet pet = new Pet();
        // создаем питомца
        RestAssured
                .given()
                .log().all() // логирование
                .body(pet)
                .header("Content-Type", "application/json")
                .post("https://petstore.swagger.io/v2/pet");

        // удаляем питомца
        Response deletePet = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .delete("https://petstore.swagger.io/v2/pet/"+pet.getId());

        Assertions.assertEquals(200, deletePet.statusCode());

        // проверяем не осталось ли питомца с нашим id
        Response expectedPet = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://petstore.swagger.io/v2/pet/"+pet.getId());

        Assertions.assertEquals(404, expectedPet.statusCode());
    }
}
