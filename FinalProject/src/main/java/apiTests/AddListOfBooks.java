package apiTests;

public class AddListOfBooks {

    private String userID;

    private CollectionOfIsbn[] collectionOfIsbns;

    public AddListOfBooks() {
    }

    public AddListOfBooks(String userID, CollectionOfIsbn[] collectionOfIsbns) {
        this.userID = userID;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserID() {
        return userID;
    }

    public CollectionOfIsbn[] getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setCollectionOfIsbns(CollectionOfIsbn[] collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
