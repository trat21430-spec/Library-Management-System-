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
        System.out.println("------------ADD BOOK----------");
        System.out.print("Book ID: ");
        newBook.setID(sc.nextLine());
        System.out.print("Title: ");
        newBook.setTitle(sc.nextLine());
        System.out.print("Author: ");
        newBook.setAuthor(sc.nextLine());
        System.out.print("Genre: ");
        newBook.setGenre(sc.nextLine());
        System.out.print("Publication Year: ");
        newBook.setYear(sc.nextInt());
        System.out.print("Quantity: ");
        newBook.setQuantity(sc.nextInt());
        sc.nextLine();
        
        System.out.print("[1] Save [2] Cancel: ");
        int confirm = sc.nextInt();
        sc.nextLine();
        
        if (confirm == 1) {
            bookList.add(newBook);
            System.out.println("Successfully added!");
        } else {
            System.out.println("Operation cancelled!"); 
        }
    }

    
}
