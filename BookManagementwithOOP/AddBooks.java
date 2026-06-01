/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopbookmanagement;

/**
 *
 * @author LOQ
 */
import java.util.Scanner;
import java.util.ArrayList;
public class AddBooks {
    public void execute(ArrayList<Books> bookList,Scanner sc){
        Books newBook = new Books();
        System.out.print("ID: ");
        newBook.setID(sc.nextLine());
        System.out.print("Title: ");
        newBook.setTitle(sc.nextLine());
        System.out.print("Author: ");
        newBook.setAuthor(sc.nextLine());
        System.out.print("Genre: ");
        newBook.setGenre(sc.nextLine());
        System.out.print("Year: ");
        newBook.setYear(sc.nextInt());
        System.out.print("Quantity: ");
        newBook.setQuantity(sc.nextInt());
        sc.nextLine();
        
        bookList.add(newBook);
        System.out.println("Successfully Added!");
    }

    
}
