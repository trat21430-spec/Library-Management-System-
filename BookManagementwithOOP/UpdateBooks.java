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
public class UpdateBooks {
    public void execute(ArrayList<Books> booksList,Scanner sc ) {
        System.out.print("Enter ID to update: ");
        String findID = sc.nextLine();
        
        for (Books b : booksList  ) {
            if (b.getID().equals(findID)) {
                System.out.print("New Title: ");
                b.setTitle(sc.nextLine());
                
                System.out.print("New Author: ");
                b.setAuthor(sc.nextLine());
                
                System.out.print("New Genre: ");
                b.setGenre(sc.nextLine());
                
                System.out.println("Updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
