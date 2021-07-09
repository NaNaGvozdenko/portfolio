package homeWork3;

// Создайте два класса-наследника вашего абстрактного класса, имплементирующих ваш интерфейс
public class DronRobot extends Robot implements IRobot {

    public DronRobot() {
    }

    //Используйте ключевое слово super в переопределении методов родительского класса;
    public DronRobot(String model, long seriaNumber, int yaerRelease) {
        super(model, seriaNumber, yaerRelease);
    }

    public DronRobot(String model, long seriaNumber, int yaerRelease, int step) {
        super(model, seriaNumber, yaerRelease, step);
    }

    public void up() {
        System.out.println("Летим вверх на " + getStep());
    }

    public void down() {
        System.out.println("Летим вниз на " + getStep());
    }

    @Override
    public void run() {
        System.out.println("Летим вперед на " + getStep());
    }

    @Override
    public void runLeft() {
        System.out.println("Летим вправо на " + getStep());
    }

    @Override
    public void runRigth() {
        System.out.println("Летим влево на " + getStep());
    }

    //В каждом классе наследнике должно быть представлено строковое описание класса, из которого ясна его суть
    @Override
    public String toString() {
        return "Наследник робот - дрон! " + super.toString();
    }
}
