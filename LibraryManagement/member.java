/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagement;

public abstract class member {
    private String id;
    private String name;
    private String phone;
    private String email;
    private int borrowdBooks;

    public member(String id, String name, String phone, String email, int borrowdBooks) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.borrowdBooks = borrowdBooks;
    }

    member(String id, String name, String phone, String email) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public  int getBorrowdBooks() {
        return this.borrowdBooks;
    }

    public void setId(String id) {
        this.id = id;
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
    //display info
   public void displayInfo() {
    System.out.printf("%-10s %-20s %-15s %-25s %-5d %-10s%n",
            id,
            name,
            phone,
            email, borrowdBooks,this.getClass().getSimpleName());
}
    int getBorrowedBooks() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public abstract int gerBorrowlimit();
           
}
