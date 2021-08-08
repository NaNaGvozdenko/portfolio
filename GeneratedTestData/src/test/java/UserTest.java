import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserTest {
    @Test // Инициализация сгенерированными данными
    void dataGeneraterTest(){
        User user = new User();
        System.out.println(user.toString());
    }

    @Test // Инициализация своими данными
    void dataSpecifiedTest(){
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atgrkg", "Dbees77*Ng" );
        Assertions.assertEquals("Ivankov", user.getName().getLastName());
        Assertions.assertEquals("Andre", user.getName().getFirstName());
        Assertions.assertEquals("Sergeevich", user.getName().getMiddleName());
    }

    @Test // Проверка возраста -  не старше 102 лет
    void ageCheckTest() {
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atgrkg", "Dbees77*Ng" );
        Assertions.assertTrue((LocalDateTime.now().getYear() - user.getBirthDay().getYear()) < 102);
    }

    @Test // Проверка возраста -  не старше 102 лет
    @RepeatedTest(100)
    void ageCheckGeneraterDataTest() {
        User user = new User();
        Assertions.assertTrue((LocalDateTime.now().getYear() - user.getBirthDay().getYear()) < 102);
        //System.out.println(user.getBirthDay());
    }

    @Test // Проверка логина - латиница + альтернатива проверки длины логина
    void loginCheckTest() {
        User user = new User();
        //System.out.println(user.getLogin());
        Pattern pattern = Pattern.compile("([A-Za-z]{6})");
        Matcher matcher = pattern.matcher(user.getLogin());
        Assertions.assertTrue(matcher.matches());
    }

    @Test // Проверка пароля - латиница, должна быть заглавная буква, спецсимвол
    void passwordCheckSimbolTest() {
        User user = new User();
        //System.out.println(user.getPassword());
        Pattern pattern = Pattern.compile("([A-Za-z0-9!\"№;%&'()*+/,.-]*)");
        Matcher matcher = pattern.matcher(user.getPassword());
        Assertions.assertTrue(matcher.matches());
    }

    @Test // Проверка пароля - на длину
    @RepeatedTest(100)
    void passwordCheckLengthTest() {
        User user = new User();
        Assertions.assertTrue(user.getPassword().length()>6);
    }

    // Пример с урока
    @Test
    void name10Test() {
        Pattern pattern = Pattern.compile("[abc]");
        Matcher matcher = pattern.matcher("abcddree");
        while (matcher.find()){
            System.out.println(matcher.replaceAll("ss"));
        }
    }
}
