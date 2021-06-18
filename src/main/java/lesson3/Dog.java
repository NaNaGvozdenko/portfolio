package main.java.lesson3;

public class Dog extends Animals{
    @Override
    void run(int speed) {
        System.out.println(getClass().getName() + " бежит со скоростью " +speed+" км/ч");
    }

    @Override
    public void getVoice() {
        System.out.println("Гав-гав" + toString());
    }

    @Override
    public String toString() {
        return " Собачка";
    }

    @Override
    public void move() {

    }
}
