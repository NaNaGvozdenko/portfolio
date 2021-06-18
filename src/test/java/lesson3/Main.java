package test.java.lesson3;

import main.java.lesson3.Cat;
import main.java.lesson3.Dog;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run(10);

        Dog dog = new Dog();
        dog.getVoice();

        dog.toString();

    }
}