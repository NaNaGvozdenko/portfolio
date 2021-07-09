package homeWork3;

// Создайте два класса-наследника вашего абстрактного класса, имплементирующих ваш интерфейс
public class VacRobot extends Robot implements IRobot {
    public VacRobot() {
    }

    //Используйте ключевое слово super в переопределении методов родительского класса;
    public VacRobot(String model, long seriaNumber, int yaerRelease) {
        super(model, seriaNumber, yaerRelease);
    }

    public VacRobot(String model, long seriaNumber, int yaerRelease, int step) {
        super(model, seriaNumber, yaerRelease, step);
    }

    @Override
    public void run() {
        System.out.println("Ползет вперед на " + getStep());
    }

    @Override
    public void runLeft() {
        System.out.println("Ползет вперед на " + getStep());
    }

    @Override
    public void runRigth() {
        System.out.println("Ползет вперед на " + getStep());
    }

    //В каждом классе наследнике должно быть представлено строковое описание класса, из которого ясна его суть
    @Override
    public String toString() {
        return " Наследник робот - пылесос! " + super.toString();
    }
}
