/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Librarymanagement;
//Book IS-A document

public class Books extends Document {

    private String author;
    private String genre;
    private int year;
    private int quantity;

    public Books() {
        super();
    }

    public Books(String id, String title, String author, String genre, int year, int quantity) {

        super(id, title);

        this.author = author;
        this.genre = genre;
        this.year = year;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
