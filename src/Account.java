import java.util.HashMap;
import java.util.Map;

public class Account {

    private String firstName = "";
    private String lastName = "";
    private String phoneNumber = "";
    private Map<Book, Integer> checkedOutBooksDue = new HashMap<>();

    public Account(String firstName, String lastName, String phoneNumber, HashMap<Book, Integer> bookData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.checkedOutBooksDue = bookData;
    }

    // Adding a book with this method is easy! Simply put
    // in the book and how many days in the future it is due!
    public void addBook(Book book, int dueIn) {
        checkedOutBooksDue.put(book, dueIn);
    }

    // Mutator Methods
    public String setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this.phoneNumber;
    }


    // Accessor Methods
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Map<Book, Integer> getCheckedOutBooksDue() {
        return checkedOutBooksDue;
    }

    public int getCheckedOutBooks() { return checkedOutBooksDue.size(); }

    public void initializeAccounts() {

    }
}
