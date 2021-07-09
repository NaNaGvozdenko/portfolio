package homeWork5;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(agressionlevel, dog.agressionlevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), agressionlevel);
    }

    @Override
    public String bark() {
        return "Гав-гав!";
    }
}
