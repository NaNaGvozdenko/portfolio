package homeWork5;

import java.util.Objects;

public abstract class Animals {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animals)) return false;
        Animals animals = (Animals) o;
        return age == animals.age && Double.compare(animals.weight, weight) == 0 && Objects.equals(name, animals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }

    @Override
    public String toString() {
        return "Животное зовут: " + name + ", возраст: " + age + " лет, вес: " + weight + " кг.";
    }

    public String bark() {
        return "Издает какой-то странный звук.";
    }

    //public abstract <T> T Duble(T elem);
}
