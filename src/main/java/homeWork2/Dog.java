package main.java.homeWork2;

public class Dog extends Animals {

    String agressionlevel;

    public Dog(String name, int age, double weight, String agressionlevel) {
        super(name, age, weight);
        this.agressionlevel = agressionlevel;
    }

    @Override
    public String toString() {
        return "Собаку зовут: " + name + ", возраст: " + age + " лет, вес: " + weight + " кг. Уровень агрессии: " + agressionlevel;
    }

    @Override
    public String bark() {
        return "Гав-гав!";
    }
}
