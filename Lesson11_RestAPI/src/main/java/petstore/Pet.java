package petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return new String[] {RandomStringUtils.randomAlphabetic(10)};
    }

    public Tags[] getTags() {
        return new Tags[] {new Tags(), new Tags()};
    }

    public String getStatus() {
        return status;
    }

    public Pet() {
        this.id = Math.abs(new Random().nextLong());
        this.category = new Category();
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.photoUrls = getPhotoUrls();
        this.tags = getTags();
        this.status = RandomStringUtils.randomAlphabetic(5);
    }

    public Pet(int id) {
        this.id = id;
        this.category = new Category();
        this.photoUrls = getPhotoUrls();
        this.tags = getTags();
        this.status = RandomStringUtils.randomAlphabetic(5);
    }

    public Pet(long id, Category category, String name, String[] photoUrls, Tags[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Pet(String status) {
        this.id = Math.abs(new Random().nextLong());
        this.category = new Category();
        this.photoUrls = getPhotoUrls();
        this.tags = new Tags[]{};
        this.status = status;
    }
}

