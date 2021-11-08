package apiTests;

public class AllBooksModal {
    private BookModal[] books;

    public AllBooksModal() {
    }

    public AllBooksModal(BookModal[] books) {
        this.books = books;
    }

    public BookModal[] getBookModal() {
        return books;
    }

    public void setBookModal(BookModal[] books) {
        this.books = books;
    }
}
