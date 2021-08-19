import java.io.Serializable;
import java.util.Random;

public class Address implements Serializable {
    private String city;
    private String street;
    private int house;
    private int flat;

    private String[] cityMass = new String[]{"Moscow", "St-Peterburg", "Kazan'", "Novosibirsk", "Krasnodar"};
    private String[] streetMass = new String[]{"Severnaya", "Krasnaya", "Oktyabrskaya", "Chapaeva", "Gorkogo"};

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getFlat() {
        return flat;
    }

    public Address() {
        Random random = new Random();
        this.city = cityMass[random.nextInt(cityMass.length)];
        this.street = streetMass[random.nextInt(streetMass.length)];
        this.house =  random.nextInt(500);;
        this.flat = random.nextInt(55);
    }

    public Address(String city, String street, int house, int flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}
