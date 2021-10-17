package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Image {
    private long petId ;
    private String additionalMetadata;
    private String file;

    public Image() {
        this.petId  = Math.abs(new Random().nextInt());
        this.additionalMetadata = RandomStringUtils.randomAlphabetic(10);
        this.file = RandomStringUtils.randomAlphabetic(10)+".jpg";
    }

    public Image(long petId) {
        this.petId  = petId;
        this.additionalMetadata = RandomStringUtils.randomAlphabetic(10);
        this.file = RandomStringUtils.randomAlphabetic(10)+".jpg";
    }

    public Image(String additionalMetadata, String file) {
        this.petId  = Math.abs(new Random().nextInt());
        this.additionalMetadata = additionalMetadata;
        this.file = file+".jpg";
    }

    public long getpetId() {
        return petId ;
    }

    public String getAdditionalMetadata() {
        return additionalMetadata;
    }

    public String getFile() {
        return file;
    }
}
