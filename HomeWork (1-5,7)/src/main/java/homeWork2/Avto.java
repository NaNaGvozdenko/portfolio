package homeWork2;

import java.util.Objects;

public class Avto {
    // Модель
    String model;
    // Цвет
    String color;
    // Год выпуска
    int yearOfIssue;
    // Мощность
    double power;
    // Количество колес
    public static final int numberOfWheels = 4;
    // Расход топлива
    double fuelConsumption;
    // Объем бака
    double volumeOfTheTank;
    // Пройденный километраж на полном баке
    double mileage;

    public Avto(String model, String color, int yearOfIssue, double power, double volumeOfTheTank, double mileage) {
        this.model = model;
        this.color = color;
        this.yearOfIssue = yearOfIssue;
        this.power = power;
        this.volumeOfTheTank = volumeOfTheTank;
        this.mileage = mileage;
        this.fuelConsumption = (mileage / volumeOfTheTank) * 100;
    }

    public static String InfoOfWheels() {
        return "У машинки " + numberOfWheels + " колесика ☺";
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", цвет: " + color + ", год выпуска: " + yearOfIssue + ", мощность: " + power + ", расход: " + Math.round(fuelConsumption) + " литров на 100км.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            System.out.println("Зачем сравнивать один и тот же класс?");
            return true;
        } else {
            System.out.println("Это разные классы, поверь");
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, yearOfIssue, power, fuelConsumption, volumeOfTheTank, mileage);
    }
}
