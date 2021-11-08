package apiTests;

public class CreateUserResult {

    private String userID;
    private String username;
    private BookModal[] books;

    public CreateUserResult() {
    }

    public CreateUserResult(String userId, String username, BookModal[] books) {
        this.userID = userId;
        this.username = username;
        this.books = books;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public BookModal[] getBooks() {
        return books;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBooks(BookModal[] books) {
        this.books = books;
    }
}
