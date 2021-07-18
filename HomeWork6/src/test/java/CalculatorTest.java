import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

// Создайте тестовый класс с тестовыми методами (фреймворк Junit)для проверки каждой функции калькулятора
@Tag("alfa")
public class CalculatorTest {

    // Классу и каждому методу задайте имя
    @Test
    @Tag("sumTestTwoParams")
    void  sumTestTwoParams(){
        System.out.println("Тест на сумму с двумя параметрами выполнен");
        Assertions.assertEquals(4, Calculator.sum(2,2));
    }

    @Test
    void  sumTestTreeParams(){
        Assertions.assertEquals(0, Calculator.sum(2,2, -4));
    }

    @Test
    void  diffTest(){
        Assertions.assertEquals(5, Calculator.diff(7,2));
    }

    @Test
    void diffTestOtr(){
        Assertions.assertEquals(10, Calculator.diff(-1,-11));
    }

    @Test
    void  powTest(){
        Assertions.assertEquals(40, Calculator.pow(5,8));
    }

    @Test
    void  diffTestOtr2(){
        Assertions.assertEquals(10, Calculator.diff(-1,-11));
    }

    // В тестовом классе должны быть параметризованный тест
    @ParameterizedTest
    @CsvSource( {"4, 6, 10", "-1, 1, 0", "0, 0, 0", "6, -10, -4", "34, -24, 10", "-21, -34, -55"})
    public void  sumTestTwoParamsParametrs(int valueA, int valueB, int answer){
        Assertions.assertEquals(answer, Calculator.sum(valueA,valueB));
    }

    @ParameterizedTest
    @CsvSource( {"6, -10, 16", "-34, -24, -10", "0, 0, 0"})
    public void  diffTestTwoParamsParametrs(int valueA, int valueB, int answer){
        Assertions.assertEquals(answer, Calculator.diff(valueA,valueB));
    }

    @RepeatedTest(3)
    public void  powTestTwoParamsRepeat(RepetitionInfo repeatedTest){
        Assertions.assertEquals(25, Calculator.pow(5,5));
        Assertions.assertEquals(3, repeatedTest.getTotalRepetitions());
    }
}
