package main.java.homeWork4;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(character, cat.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), character);
    }

    @Override
    public String bark() {
        return "Мяу-мяу!";
    }
}
