import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Некорректные данные - негативные АТ
public class TestHelper {
    @Test // Проверка возраста -  указан более 102
    @RepeatedTest(100)
    void ageCheckNegTest() {
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1794, 05, 9), LocalDateTime.now(), "Atgrkg", "Dbees77*Ng" );
        Assertions.assertFalse((LocalDateTime.now().getYear() - user.getBirthDay().getYear()) < 102);
    }

    @Test // Проверка логина - присутствуют цифры
    void loginCheckNumericNegTest() {
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atg8785rkg", "Dbees77*Ng" );
        Pattern pattern = Pattern.compile("([A-Za-z]{6})");
        Matcher matcher = pattern.matcher(user.getLogin());
        Assertions.assertFalse(matcher.matches());
    }

    @Test // Проверка пароля - отсутствуют спец символы
    void passwordCheckSpecialSimbolNegTest() {
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atgrkg", "Dbees77Ng" );
        Pattern pattern = Pattern.compile("([A-Za-z0-9]*[!\"№;%&'()*+/,.-]+)");
        Matcher matcher = pattern.matcher(user.getPassword());
        Assertions.assertFalse(matcher.matches());
    }

    @Test // Проверка пароля - короткий пароль
    void passwordLengthShotNegTest() {
        User user = new User(new FullName("Ivankov", "Andre",  "Sergeevich"), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atgrkg", "DbNg" );
        Assertions.assertFalse(user.getPassword().length()>6);
    }
}
