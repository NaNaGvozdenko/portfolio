package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Tags {
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private long id;
    private String name;

    public Tags() {
        this.id = Math.abs(new Random().nextLong());
        this.name = RandomStringUtils.randomAlphabetic(10);
    }
}
