package homeWork3;

import java.util.Random;

//создайте абстрактный класс любого объекта окружающего мира;
public abstract class Robot {
    // В этом классе должны содержаться только приватные параметры и геттеры/сеттеры, если они необходимы
    private String model;
    private long seriaNumber;
    private int yaerRelease;
    private int step = 0;

    public int getStep() {
        if (step != 0) {
            return step;
        } else {
            return (int) (Math.random() * 6) + 5;
        }
    }

    public Robot() {
    }

    public Robot(String model, long seriaNumber, int yaerRelease) {
        this.model = model;
        this.seriaNumber = seriaNumber;
        this.yaerRelease = yaerRelease;
    }

    public Robot(String model, long seriaNumber, int yaerRelease, int step) {
        this.model = model;
        this.seriaNumber = seriaNumber;
        this.yaerRelease = yaerRelease;
        this.step = step;
    }

    @Override
    public String toString() {
        return "Родительский абстрактный класс Robot. \nМодель: " + model + "," +
                " \nсерийный номер: " + seriaNumber +
                "\nгод выпуска: " + yaerRelease;
    }
}