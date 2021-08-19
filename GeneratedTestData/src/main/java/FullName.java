import java.io.Serializable;
import java.util.Random;

public class FullName implements Serializable {
    private String firstName;
    private String lastName;
    private String middleName;

    private String[] firstNameMass = new String[]{"Ivanov", "Petrov", "Sidorov", "Kalinin", "Serbok"};
    private String[] lastNameMass = new String[]{"Anton", "Alex", "Dima", "Ilya", "Sergey"};
    private String[] middleNameMass = new String[]{"Ivanovich", "Petrovich", "Sergeevich", "Alexseevich"};

    public FullName() {
        Random random = new Random();
        this.firstName = firstNameMass[random.nextInt(firstNameMass.length)];
        this.lastName = lastNameMass[random.nextInt(lastNameMass.length)];
        this.middleName = middleNameMass[random.nextInt(middleNameMass.length)];
    }

    public FullName(String lastName, String firstName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }
}
