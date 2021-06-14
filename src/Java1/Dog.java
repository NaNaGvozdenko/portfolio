package Java1;

public class Dog extends Animals {

    String agressionlevel;

    public Dog(String _name, int _age, double _weight, String _agressionlevel) {
        super(_name, _age, _weight);
        agressionlevel = _agressionlevel;
    }

    @Override
    public String Info(){
        return "Собаку зовут: "+name+", возраст: " + age + " лет, вес: "+weight +" кг. Уровень агрессии: " + agressionlevel;
    }
    @Override
    public String bark(){
        return "Гав-гав!";
    }
}
