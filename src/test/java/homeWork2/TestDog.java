package test.java.homeWork2;

import main.java.homeWork2.Animals;
import main.java.homeWork2.Cat;
import main.java.homeWork2.Dog;

public class TestDog {
    public static void main(String[] args) {
        Animals dog = new Dog("Тор", 3, 25, "Низкий");
        Animals cat = new Cat("Муся", 7, 4, "Ласковая");
        Animals animals = new Animals("Мурка", 3, 25);

        System.out.println("Строковое представление класса Dog " + dog.bark());
        System.out.println("Строковое представление класса Cat " + cat.bark());
        System.out.println("Строковое представление класса Animals " + animals.bark());

        System.out.println(dog.toString());
        System.out.println(cat.toString());
        System.out.println(animals.toString());
    }
}
