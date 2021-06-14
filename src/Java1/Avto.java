package Java1;

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

    public Avto( String _model, String _color, int _yearOfIssue, double _power, double _volumeOfTheTank, double _mileage){
        model = _model;
        color = _color;
        yearOfIssue = _yearOfIssue;
        power = _power;
        volumeOfTheTank = _volumeOfTheTank;
        mileage = _mileage;
        fuelConsumption = (mileage / volumeOfTheTank) * 100;
    }

    public String InfoOfCar()
    {
        return "Модель: "+model+", цвет: "+color+", год выпуска: "+yearOfIssue+ ", мощность: "+power+", расход: "+ fuelConsumption +" литров на 100км.";
    }

    public static String InfoOfWheels(){
        return "У машинки "+numberOfWheels+ " колесика ☺"  ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avto)) return false;
        Avto avto = (Avto) o;
        return yearOfIssue == avto.yearOfIssue && Double.compare(avto.power, power) == 0 && Double.compare(avto.fuelConsumption, fuelConsumption) == 0 && volumeOfTheTank == avto.volumeOfTheTank && mileage == avto.mileage && Objects.equals(model, avto.model) && Objects.equals(color, avto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, yearOfIssue, power, fuelConsumption, volumeOfTheTank, mileage);
    }
}
