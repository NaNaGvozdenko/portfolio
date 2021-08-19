import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class User implements Serializable {
    private FullName name; // ФИо  с залавной буквы по формату Иванов Иван Иванович
    private Address address;
    private LocalDate birthDay; // Дата в виде года 1991
    private LocalDateTime registrationDate; // Дата в виде 2020-01-01Т00:00:00

    public FullName getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String login; // 6 знакой алфавитно-числовой на латинице
    private String password; // 10 знаков алфавитно-цифровой на латинице

    public User(FullName name, LocalDate birthDay, LocalDateTime registrationDate, String login, String password) {
        this.name = name;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }

    // Для домашней работы 9 + генерация адреса
    public User(FullName name, Address address, LocalDate birthDay, LocalDateTime registrationDate, String login, String password) {
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }

    public User() {
        this.name = generateRandomName();
        this.address = new Address();
        this.birthDay = generateRandomDate();
        this.registrationDate = generateRandomRegistrationDate();
        this.login = generateRandomLogin(6);
        this.password = generateRandomPassword(10);
    }

    @Override
    public String toString() {
        return "User{" +
                "name: '" + name.getFirstName() + " " + name.getLastName() + " " +name.getMiddleName() + '\'' +
                "address: city " + address.getCity() + ", street " + address.getStreet() + ", house " + address.getHouse() + ", flat " + address.getFlat()+
                ", birthDay: " + birthDay +
                ", registrationDate: " + registrationDate +
                ", login: '" + login + '\'' +
                ", password: '" + password + '\'' +
                '}';
    }

    // Создать конструктор, в котором инициализация полей осуществлялась с помощью методов-генераторов
    // генератор даты рождения формата “yyyy-MM-dd” не старше 102 лет)
    private LocalDate generateRandomDate(){
        Random random = new Random();
        int minDay = (int) LocalDate.now().minusYears(101).toEpochDay();
        int maxDay = (int) LocalDate.now().toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }


    private FullName generateRandomName(){
        name = new FullName();
        return name;
    }

    private String generateRandomName(FullName fullName){
        return fullName.getFirstName() +" "+ fullName.getLastName().charAt(0)+". "+fullName.getMiddleName().charAt(0)+".";
    }

    // Генератор даты регистрации – указание текущей даты с точностью до секунд
    private LocalDateTime generateRandomRegistrationDate(){
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedDate =  LocalDateTime.parse(nowDate.format(formatter), formatter);
        return parsedDate;
    }

    // генератор логина – латиница, не больше 6 символов;
    private String generateRandomLogin(int count){
        return generateRandomRefactor(count);
    }

    // генератор пароля – латиница, должна быть заглавная буква,
    // спецсимвол, не меньше 6 символов
    private String generateRandomPassword(int count){
        return generateRandomRefactor(count, 1);
    }

    // Генерация по количеству символов только латиницей
    private String generateRandomRefactor(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    private String generateRandomRefactor(int count, int countSpec) {
        // Специальные символы
        String spec = new Random().ints(countSpec, 33, 47)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        // Верхний регистр
        String latUp = new Random().ints(3, 65, 90)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        // Нижний регистр
        String latDown = new Random().ints(3, 97, 122)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        // цифры
        String numer = new Random().ints(3, 48, 57)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return latUp+spec+latDown+numer;
    }
}
