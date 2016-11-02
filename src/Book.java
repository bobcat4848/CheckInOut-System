
public class Book {

    private String bookTitle = "";
    private String bookGenre = "";

    public Book(String bookTitle, String bookGenre) {
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
    }

    // Accessor Methods
    public String getBookTitle() {
        return this.bookTitle;
    }

    public String getBookGenre() {
        return this.bookGenre;
    }
}
