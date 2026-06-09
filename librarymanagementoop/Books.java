/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOQ
 */
package librarymanagementoop;
public class Books {

    private String id;
    private String author;
    private String genre;
    private String title;
    private int year;
    private int quantity;

    public void setID(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getID() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getTitle() {
        return this.title;

    }

    public int getYear() {
        return this.year;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
