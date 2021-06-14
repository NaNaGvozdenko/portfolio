package Java1;

public class Cat extends Animals {

    String character;
    public Cat(String _name, int _age, double _weight, String _character) {
        super(_name, _age, _weight);
        character = _character;
    }

    @Override
    public String Info(){
        return "Кошечку зовут: "+name+", возраст: " + age + " лет, вес: "+weight +" кг. Характер: " +character ;
    }

    @Override
    public String bark(){
        return "Мяу-мяу!";
    }
}
