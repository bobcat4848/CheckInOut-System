package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {

    private String firstName = "";
    private String lastName = "";
    private String phoneNumber = "";
    private int amountOfBooks;

    public Account(String firstName, String lastName, String phoneNumber, int amountOfBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.amountOfBooks = amountOfBooks;
    }

    // Adding a book with this method is easy! Simply put
    // in the book and how many days in the future it is due!
    public int addBook(int amount) {
        amountOfBooks += amount;
        return amountOfBooks;
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

    public Integer getBooks() {
        return amountOfBooks;
    }
}
