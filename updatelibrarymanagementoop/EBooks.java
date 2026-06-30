/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package updatelibrarymanagementoop;

/**
 *
 * @author LOQ
 */
public class EBooks extends Books {
    private double fileSizeMB;
    

    public EBooks() {
    }

    public EBooks(String id, String title, String author, String genre, int year, int quantity,double fileSizeMB) {
        super(id, title, author, genre, year, quantity);
        this.fileSizeMB = fileSizeMB;
    }
    public double getFileSize(){
        return this.fileSizeMB;
    } 
    public void setFileSize(double fileSizeMB){
        this.fileSizeMB = fileSizeMB;
    }
    
    
}
