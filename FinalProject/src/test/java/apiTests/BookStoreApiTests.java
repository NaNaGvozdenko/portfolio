package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookStoreApiTests {

    // Получение списка книг
    @Test
    void getBooks(){
        Response response  = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://demoqa.com/BookStore/v1/Books");
        System.out.println(response.asString());
        Assertions.assertEquals(200, response.statusCode());
    }

    // Добавление и удаление книги
    // Пользователю f6fb3a7e-061d-438b-b97a-5388b0912178
    @Test
    void addBooksUsers(){
        AddListOfBooks addListOfBooks = new AddListOfBooks("f6fb3a7e-061d-438b-b97a-5388b0912178", new CollectionOfIsbn[]{new CollectionOfIsbn("9781449325862")});

        Response response  = RestAssured
                .given()
                .log().all() // логирование
                .body(addListOfBooks)
                .header("Content-Type", "application/json")
                .auth().basic("AdminUser123","Admin123*")
                .post("https://demoqa.com/BookStore/v1/Books");

        Response responseDel = RestAssured
                .given()
                .log().all() // логирование
                .baseUri("https://demoqa.com/Account/v1/Authorized")
                .auth().basic("AdminUser123","Admin123*")
                .header("Content-Type", "application/json")
                .delete("https://demoqa.com/BookStore/v1/Books?UserId="+addListOfBooks.getUserID());

        Assertions.assertEquals(204, responseDel.statusCode());
    }

    // Добавление такой же книги
    // Пользователю f6fb3a7e-061d-438b-b97a-5388b0912178
    @Test
    void addBooksUserDouble401(){
        AddListOfBooks addListOfBooks = new AddListOfBooks("f6fb3a7e-061d-438b-b97a-5388b0912178", new CollectionOfIsbn[]{new CollectionOfIsbn("9781449325862")});

        Response response  = RestAssured
                .given()
                .baseUri("https://demoqa.com/Account/v1/Authorized")
                .auth().basic("AdminUser123","Admin123*")
                .log().all() // логирование
                .body(addListOfBooks)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/BookStore/v1/Books");
        Assertions.assertEquals(401, response.statusCode());
    }

    // Получение книги по ид
    // Пользователю f6fb3a7e-061d-438b-b97a-5388b0912178
    /*@Test
    void getBook200(){

        // Получаем список книг
        BookModal responseBooks  = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://demoqa.com/BookStore/v1/Books").as(AllBooksModal.class).getBookModal()[0];

        // Получаем первую из списка
        Response response  = RestAssured
                .given()
                .log().all() // логирование
                .header("Content-Type", "application/json")
                .get("https://demoqa.com/BookStore/v1/Book?ISBN="+responseBooks.getIsbn());
        Assertions.assertEquals(200, response.statusCode());
    }*/
}