import org.junit.jupiter.api.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HW9FilesTest {
    private static String path = "C:\\test.txt";
    private static String pathUsers = "C:\\users.txt";
    private static String pathAddresses = "C:\\addresses.txt";

    @BeforeAll
    static void createFileTest() {
        File files = new File(path);
        try {
            if (files.createNewFile())
                System.out.println("Create test.txt successfull!");
            files =new File(pathUsers);
            if (files.createNewFile())
                System.out.println("Create users.txt successfull!");
            files =new File(pathAddresses);
            if (files.createNewFile())
                System.out.println("Create addresses.txt successfull!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void dataGeneraterTest() {
        User user = new User();
        System.out.println(user.toString());
    }

    // Создайте для пользователя возможность указания домашнего адреса с полями: город, улица, дом, квартира;
    @Test
    // Инициализация своими данными
    void addressFactTest() {
        User user = new User(new FullName("Ivankov", "Andre", "Sergeevich"), new Address("Krasnodar", "Krasnayz", 55, 3), LocalDate.of(1994, 05, 9), LocalDateTime.now(), "Atgrkg", "Dbees77*Ng");
        Assertions.assertEquals("Krasnodar", user.getAddress().getCity());
        Assertions.assertEquals("Krasnayz", user.getAddress().getStreet());
        Assertions.assertEquals(55, user.getAddress().getHouse());
        Assertions.assertEquals(3, user.getAddress().getFlat());
    }

    @Test
        // Проверяем что адреса
    void noAddressTest() {
        User user = new User();
        System.out.println(user.getAddress().getCity());
        Assertions.assertTrue(Pattern.compile("([A-Za-z'-]*)").matcher(user.getAddress().getCity()).matches());
        System.out.println(user.getAddress().getStreet());
        Assertions.assertTrue(Pattern.compile("([A-Za-z'-]*)").matcher(user.getAddress().getStreet()).matches());
    }

    // Объект User должен быть доступен для сериализации с учетом обновления;
    @Test
    void serializationTest() {
        User user = new User();
        System.out.println(user);
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Объект User должен быть доступен для десериализации с учетом обновления;
    @Test
    void deserializationTest() {
        try {
            FileInputStream s = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(s);
            User user = (User) ois.readObject();
            ois.close();
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Создайте список из 10 пользователей;
    // Сохраните список в файле users.txt;
    @Test
    void createUsersList() {
        ArrayList<User> listUsers = new ArrayList<>();
        for (int i=0; i<10; i++)
            listUsers.add(new User());
        try {
            FileOutputStream fos = new FileOutputStream(pathUsers);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listUsers);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Получите список адресов и сохраните его в файле addresses.txt
    @Test
    void getUsersListAndSaveAddressListTest(){
        try {
            FileInputStream s = new FileInputStream(pathUsers);
            ObjectInputStream ois = new ObjectInputStream(s);
            ArrayList<User> userList = (ArrayList<User>) ois.readObject();
            ois.close();
            ArrayList<Address> addressList = new ArrayList<>();
            for (var i: userList) {
                addressList.add(i.getAddress());
            }
            FileOutputStream fos = new FileOutputStream(pathAddresses);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(addressList);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    static void deleteFileTest() {
        File files = new File(path);
        try {
            if (files.delete())
                System.out.println("Delete successfull!");
            /*files = new File(pathUsers);
            if (files.delete())
                System.out.println("Delete successfull!");
            files = new File(pathAddresses);
            if (files.delete())
                System.out.println("Delete successfull!");*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
