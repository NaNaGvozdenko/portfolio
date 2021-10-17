package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class UpdataPet {
    private long petId;
    private String name;
    private String status;

    public long getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public UpdataPet() {
        this.petId = Math.abs(new Random().nextLong());
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.status = RandomStringUtils.randomAlphabetic(5);
    }

    public UpdataPet(long petId) {
        this.petId = petId;
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.status = RandomStringUtils.randomAlphabetic(5);
    }
}
