package apiTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@Epic("Books store account")
//@Feature("User Tests")
class AccountApiTests {

    // Авторизация: успешная
    @Test
    //@Step("Успешная авторизация пользователя")
    void authorized200(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser123","Admin123*");
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/Account/v1/Authorized");

        Assertions.assertEquals(200, response.statusCode());
    }

    // Авторизация: Не найден пользователь
    @Test
    //@Step("Ошибка авторизации - пользователь не найден")
    void authorized404(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser123","Admin123");
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/Account/v1/Authorized");

        Assertions.assertEquals(404, response.statusCode());
    }

    // Пароль подходит под маску
    @Test
    //@Step("Верный пароль")
    void generateToken200(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser123","Admin123*");
        TokenViewModel response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/Account/v1/GenerateToken").as(TokenViewModel.class);
        Assertions.assertEquals("Success", response.getStatus());
    }

    // Пароль не подходит под маску - только цифры и буквы в пароле, НЕТ символа
    @Test
    //@Step("Некорректный пароль")
    void generateTokenFail(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser123","Admin123");
        TokenViewModel response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/Account/v1/GenerateToken").as(TokenViewModel.class);

        System.out.println(response.getResult());
        Assertions.assertEquals("Failed", response.getStatus());
    }

    // Создание пользователя успешное (с возможностью повторного запуска АТ при помощи удаления и проверки на наличие)
    @Test
    //@Step("Пользователь создан успешно")
    void userCreate200(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser456","Admin456*");
        Response response = RestAssured
                .given()
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .post("https://demoqa.com/Account/v1/User");

        Assertions.assertEquals(201, response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.as(CreateUserResult.class).getUserID());

        // Удаляем
        Response delete = RestAssured
                .given()
                .baseUri("https://demoqa.com/Account/v1/Authorized")
                .auth().basic("AdminUser456","Admin456*")
                .log().all() // логирование
                .body("{\"userName\": \"AdminUser456\", \"password\": \"Admin4563*\"}")
                .header("Content-Type", "application/json")
                .delete("https://demoqa.com/Account/v1/User/"+response.as(CreateUserResult.class).getUserID());

        Assertions.assertEquals(200, delete.statusCode());

        // Проверяем после удаления
        Response expectedAnsw = RestAssured
                .given()
                .log().all() // логирование
                .baseUri("https://demoqa.com/Account/v1/Authorized")
                .auth().basic("AdminUser456","Admin456*")
                .header("Content-Type", "application/json")
                .get("https://demoqa.com/Account/v1/User/"+response.as(CreateUserResult.class).getUserID());

        System.out.println(expectedAnsw.asString());
        Assertions.assertEquals(401, expectedAnsw.statusCode());

    }

    // Создание пользователя - пользователь существует
    @Test
    //@Step("Такой пользователь существует")
    void userCreate406(){
        LoginViewModel loginViewModel  = new LoginViewModel("AdminUser123","Admin123*");
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .log().all() // логирование
                .body(loginViewModel)
                .header("Content-Type", "application/json")
                .auth().basic("AdminUser123","Admin123")
                .post("https://demoqa.com/Account/v1/User");
        System.out.println(response.asString());
        Assertions.assertEquals(406, response.statusCode());
    }
}
