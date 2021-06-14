package com.company;

import Java1.Animals;
import Java1.Cat;
import Java1.Dog;

public class TestDog {
    public static void main(String[] args) {
        Animals dog = new Dog("Тор", 3, 25, "Низкий");
        Animals cat = new Cat("Муся", 7, 4, "Ласковая");
        Animals animals = new Animals("Мурка", 3, 25);

        System.out.println("Строковое представление класса Dog" + dog.bark()+" "+dog.Info());
        System.out.println("Строковое представление класса Cat" + cat.bark()+" "+cat.Info());
        System.out.println("Строковое представление класса Animals" + animals.bark()+" "+animals.Info());

        System.out.println(dog.toString());
        System.out.println(cat.toString());
        System.out.println(animals.toString());
    }
}
