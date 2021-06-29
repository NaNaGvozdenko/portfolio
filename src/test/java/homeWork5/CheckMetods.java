package test.java.homeWork5;

import main.java.homeWork4.Dog;
import main.java.homeWork5.Cat;

import java.util.*;

import static main.java.homeWork5.Metods.GetNoDuplicate;
import static main.java.homeWork5.Metods.inverse;

// Напишите тестовый класс, проверяющий корректность реализации ваших методов с учетом разных входных параметров
public class CheckMetods {

    public static void main(String[] args) {
        // Лист кошечек
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Кузя", 3, 3.3, "low"));
        cats.add(new Cat("Буся", 2, 4, "middle"));
        cats.add(new Cat("Васяка", 4, 6, "high"));
        cats.add(new Cat("Муська", 5, 3.5, "middle"));
        cats.add(new Cat("Кузя", 3, 3.3, "low")); // дубль
        cats.add(new Cat("Рыжуля", 1, 3.9, "middle"));
        cats.add(new Cat("Мимишка", 7, 7.3, "high"));

        // Лист собачек
        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("Болто", 3, 3.3, "low"));
        dogList.add(new Dog("Пика", 2, 7.3, "high"));
        dogList.add(new Dog("Лада", 1, 8.5, "middle"));
        dogList.add(new Dog("Жучка", 4, 45.3, "high"));
        dogList.add(new Dog("Болто", 3, 3.3, "low"));

        // Напишите метод, который на вход получает коллекцию объектов любого типа, а возвращает коллекцию, но уже без дубликатов
        System.out.println("Количество элементов в исходном листе cats: " + cats.size());
        System.out.println("Количество элементов после вызова метода, исключающего дубли: " + GetNoDuplicate(cats).size());

        System.out.println("Количество элементов в исходном листе dogList: " + dogList.size());
        System.out.println("Количество элементов после вызова метода, исключающего дубли: " + GetNoDuplicate(dogList).size());

        //  Напишите метод, который получает на вход Map<K, V> и возвращает Map, где ключи и значения поменяны местами.
        // Сигнатура метода: <K, V> Map<V, Collection<K>> inverse(Map<K, V> map);
        Map elem = new HashMap();
        elem.put(1, "один");
        elem.put(2, "два");
        elem.put(3, "три");
        elem.put(4, "четыре");
        elem.put(5, "пять");

        System.out.println(elem.get(4)); // до инверсии используем ключ целочисленный - 4
        System.out.println(inverse(elem).get("четыре")); // после инверсии ключ сторовый - четыре
    }
}
