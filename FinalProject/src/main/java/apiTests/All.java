package apiTests;

public class All {
    private BookModal books;

    public All() {
    }

    public All(BookModal books) {
        this.books = books;
    }

    public BookModal getBookModal() {
        return books;
    }

    public void setBookModal(BookModal books) {
        this.books = books;
    }
}
