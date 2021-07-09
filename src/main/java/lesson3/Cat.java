package lesson3;

public class Cat extends Animals{
    @Override
    public void run(int speed) {
        System.out.println(getClass().getName() + " бежит со скоростью " +speed+" км/ч");
    }

    @Override
    void getVoice() {
        System.out.println("Мяу-мяу" + toString());
    }

    @Override
    public String toString() {
        return " Кошечка";
    }

    @Override
    public void move() {

    }
}
