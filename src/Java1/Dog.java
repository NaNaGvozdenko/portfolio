package Java1;

public class Dog {
    private String name;
    private int age;
    private double weight;

    public static final int COUNT = 4;

    public Dog(String _name, int _age, double _weight){
        name = _name;
        age = _age;
        weight = _weight;
    }

    public String Info(){
        return "Собаку зовут: "+name+", возраст: " + age + " лет, вес: "+weight +" кг.";
    }

    public static String bark(){
        return "Гав-гав";
    }
    public void run(){}
    public void giveAPaw(){}
}
