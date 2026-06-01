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

public class SearchBooks {
    public void execute(ArrayList<Books> BooksList,Scanner sc) {
        System.out.print("Enter a keyword: ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;
        
        for (Books b : BooksList) {
            if (b.getTitle().toLowerCase().contains(key) || 
                b.getAuthor().toLowerCase().contains(key) || 
                b.getGenre().toLowerCase().contains(key)) {
                System.out.println("- " + b.getTitle() + " (by " + b.getAuthor() + ")");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Not found!");
        }
    }
}