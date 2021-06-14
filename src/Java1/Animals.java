package Java1;

public class Animals {
    // Имя
    protected String name;
    // Возраст
    protected int age;
    // Вес
    protected double weight;
    // Количество лапок
    public static final int COUNT = 4;

    public Animals(String _name, int _age, double _weight){
        this.name = _name;
        this.age = _age;
        this.weight = _weight;
    }
    public String Info(){
        return "Животное зовут: "+name+", возраст: " + age + " лет, вес: "+weight +" кг.";
    }

    public String bark(){
        return "Издает какой-то странный звук.";
    }
}
