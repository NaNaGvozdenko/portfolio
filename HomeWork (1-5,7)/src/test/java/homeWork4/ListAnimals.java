package homeWork4;

import java.util.*;

public class ListAnimals {
    public static void main(String[] args) {
        // - Создайте 2 списка: список кошек и собак. Наполните списки объектами с разным набором полей: имя, возраст, цвет. Пусть в списках будут
        // как одинаковые кошки и собаки (совпадение всех полей), так и оригинальные животные;
        List<Dog> dogList = new ArrayList();
        dogList.add(new Dog("Болто", 3, 3.3, "low"));
        dogList.add(new Dog("Пика", 2, 7.3, "high"));
        dogList.add(new Dog("Лада", 1, 8.5, "middle"));
        dogList.add(new Dog("Жучка", 4, 45.3, "high"));
        dogList.add(new Dog("Болто", 3, 3.3, "low"));
        System.out.println(dogList);

        List<Cat> catList = new ArrayList();
        catList.add(new Cat("Кузя", 3, 3.3, "low"));
        catList.add(new Cat("Буся", 2, 4, "middle"));
        catList.add(new Cat("Васяка", 4, 6, "high"));
        catList.add(new Cat("Муська", 5, 3.5, "middle"));
        catList.add(new Cat("Кузя", 3, 3.3, "low"));
        catList.add(new Cat("Рыжуля", 1, 3.9, "middle"));
        catList.add(new Cat("Мимишка", 7, 7.3, "high"));
        System.out.println(catList);

        // Переведите списки во множества. Убедитесь в отсутствии дублирующих объектов ***Переопределение equals
        System.out.println("В списке Dog: " + dogList.size());
        Set dogSet = new HashSet(dogList);
        System.out.println("Во множестве Dog: " + dogSet.size());

        System.out.println("В списке Cat: " + catList.size());
        Set catSet = new HashSet(catList);
        System.out.println("Во множестве Cat: " + catSet.size());

        // Создайте одну карту. Наполните ее вашими множествами. В качестве ключей используйте “Кошка”, “Собака”.
        Map animalsMap = new HashMap();
        animalsMap.put("Собака", dogSet);
        animalsMap.put("Кошка", catSet);
        System.out.println(animalsMap.size());
    }
}