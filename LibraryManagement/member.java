package Librarymanagement;

public abstract class member {

    private String id;
    private String name;
    private String phone;
    private String email;
    private int borrowedBooks;

    public member(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.borrowedBooks = 0;
    }

   
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getBorrowedBooks() {
        return this.borrowedBooks;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

  
    public abstract void displayInfo();

    
    public abstract String getMemberType();
}