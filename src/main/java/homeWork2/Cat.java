package main.java.homeWork2;

public class Cat extends Animals {

    String character;

    public Cat(String name, int age, double weight, String character) {
        super(name, age, weight);
        this.character = character;
    }

    @Override
    public String toString() {
        return "Кошечку зовут: " + name + ", возраст: " + age + " лет, вес: " + weight + " кг. Характер: " + character;
    }

    @Override
    public String bark() {
        return "Мяу-мяу!";
    }
}
