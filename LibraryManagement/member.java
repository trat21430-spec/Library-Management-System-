package LibraryManagement;

public abstract class member {

    private String id;
    private String name;
    private String phone;
    private String email;
    private int borrowdBooks;

    public member(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.borrowdBooks = 0;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getBorrowedBooks() {
        return this.borrowdBooks;
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

    public void setBorrowdBooks(int borrowdBooks) {
        this.borrowdBooks = borrowdBooks;
    }

    public void displayInfo() {
        System.out.printf("%-10s %-20s %-15s %-25s %-5d %-15s%n",
                id,
                name,
                phone,
                email,
                borrowdBooks,
                this.getClass().getSimpleName());
    }

    public abstract int getBorrowLimit();
}