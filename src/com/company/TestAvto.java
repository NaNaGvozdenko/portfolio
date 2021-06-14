package com.company;

import Java1.Avto;

public class TestAvto {
    public static void main(String[] args) {
        Avto avto1 = new Avto("Opel", "Red", 2020, 112.6, 450, 45);
        Avto avto2 = new Avto("Mazda", "Yellow", 2021, 116.3, 420, 45);
        Avto avto3 = new Avto("Lada", "Black", 2020, 78.6, 500, 45);
        System.out.println(Avto.InfoOfWheels());
        System.out.println(avto1.InfoOfCar());

        System.out.println(avto1.toString());
        System.out.println(avto2.toString());
        System.out.println(avto3.toString());

        System.out.println(avto1.equals(avto2));
        System.out.println(avto2.equals(avto3));
        System.out.println(avto2.equals(avto2));


    }
}
