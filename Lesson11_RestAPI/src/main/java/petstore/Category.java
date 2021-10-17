package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Category {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category() {
        this.id = Math.abs(new Random().nextLong());
        this.name = RandomStringUtils.randomAlphabetic(10);
    }
}
