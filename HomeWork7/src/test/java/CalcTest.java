
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalcTest {

    // Классу и каждому методу задайте имя
    @Test
    void  sumTestTwoParams(){
        System.out.println("Тест на сумму с двумя параметрами выполнен");
        Assert.assertEquals(4, Calc.sum(2,2));
    }

    @Test
    void  sumTestTreeParams(){
        Assert.assertEquals(0, Calc.sum(2,2, -4));
    }

    @Test
    void  diffTest(){
        Assert.assertEquals(5, Calc.diff(7,2));
    }

    @Test
    void diffTestOtr(){
        Assert.assertEquals(10, Calc.diff(-1,-11));
    }

    @Test
    void  powTest(){
        Assert.assertEquals(40, Calc.pow(5,8));
    }

    @Test
    void  diffTestOtr2(){
        Assert.assertEquals(10, Calc.diff(-1,-11));
    }

    // В тестовом классе должны быть параметризованный тест
    @Parameters( {"4, 6, 10", "-1, 1, 0", "0, 0, 0", "6, -10, -4", "34, -24, 10", "-21, -34, -55"})
    public void  sumTestTwoParamsParametrs(int valueA, int valueB, int answer){
        Assert.assertEquals(answer, Calc.sum(valueA,valueB));
    }

    @Parameters( {"6, -10, 16", "-34, -24, -10", "0, 0, 0"})
    public void  diffTestTwoParamsParametrs(int valueA, int valueB, int answer){
        Assert.assertEquals(answer, Calc.diff(valueA,valueB));
    }
}
