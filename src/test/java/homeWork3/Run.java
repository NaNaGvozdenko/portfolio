package homeWork3;

public class Run {
    public static void main(String[] args) {
        // Передаем 4 параметра в конструкторе
        DronRobot dr = new DronRobot("Панда", 1245556, 2020, 5);
        // Выведите на экран строковое представление каждого экземпляра
        System.out.println(dr.toString());
        dr.run();
        dr.up();
        dr.runRigth();
        dr.runLeft();
        dr.down();

        // Передаем три параметра в конструкторе
        VacRobot vr = new VacRobot("Кёрхер", 878374, 2021);
        // Выведите на экран строковое представление каждого экземпляра
        System.out.println(vr.toString());
        vr.run();
        vr.runLeft();
        vr.runRigth();
    }
}
