package homeWork2;

public class DataTypes {
    // В классе DataTypes создайте переменные всех перечисленных выше классов оболочек и инициализируйте их любыми значениями
    static Byte butes = new Byte("49");
    static Short shorts = new Short("4");
    static Integer integers = new Integer(5);
    static Long longs = new Long(15624654);
    static Float floats = new Float(12.5);
    static Double doubles = new Double(152.5);
    static Character characters = new Character('a');
    static Boolean booleans = new Boolean(true);

    // В классе DataTypes создайте строковую переменную и задайте ей числовое значение
    static String strings = String.valueOf(45);

    // В классе DataTypes создайте целочисленную переменную типа int и инициализируйте ее
    static int ints = 115;

    public static void main(String[] args) {
        // Создайте точку входа в классе DataTypes и выведете на экран значения примитивов каждого класса оболочки
        System.out.println(butes);
        System.out.println(shorts);
        System.out.println(integers);
        System.out.println(longs);
        System.out.println(floats);
        System.out.println(doubles);
        System.out.println(characters);
        System.out.println(booleans);
        System.out.println("*****");

        // В методе main выведете на экран целочисленное значение строковой переменной и значение переменной int в виде класса обертки
        System.out.println(Integer.parseInt(strings));
        System.out.println(Integer.valueOf(ints));
    }
};
