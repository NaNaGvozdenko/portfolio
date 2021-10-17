package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class DeletePet {
    private long petId;

    public long getPetId() {
        return petId;
    }

    public DeletePet() {
        this.petId = Math.abs(new Random().nextLong());
    }

    public DeletePet(long petId) {
        this.petId = petId;
    }
}
