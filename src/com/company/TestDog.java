package com.company;

import Java1.Dog;

public class TestDog {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Тор", 3, 25);
        Dog dog2 = new Dog("Муря", 7, 4);
        System.out.println(dog1.Info());
        System.out.println(dog2.Info());

        System.out.println("Количество лапок: "+Dog.COUNT);
        System.out.println(Dog.bark());
    }
}
