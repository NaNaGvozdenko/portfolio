package homeWork2;

public class Animals {
    // Имя
    protected String name;
    // Возраст
    protected int age;
    // Вес
    protected double weight;
    // Количество лапок
    public static final int COUNT = 4;

    public Animals(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Животное зовут: " + name + ", возраст: " + age + " лет, вес: " + weight + " кг.";
    }

    public String bark() {
        return "Издает какой-то странный звук.";
    }
}
