/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopbookmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LOQ
 */
public class ViewBooks {

    public void execute(ArrayList<Books> bookList, Scanner sc) {
        if (bookList.isEmpty()) {
            System.out.print("No books available");

        } else {

            System.out.printf("%-6s %-20s %-20s %-15s %-6s %-4s\n",
                    "ID", "Title", "Author", "Genre", "Year", "Qty");

            System.out.println("-------------------------------------------------------");
            for (Books b : bookList) {
                System.out.printf("%-6s %-20s %-20s %-15s %-6d %-4d\n",
                        b.getID(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getGenre(),
                        b.getYear(),
                        b.getQuantity());
            }
            System.out.println("-------------------------------------------------------------------------------");

        }
        System.out.print("\nPress ENTER to return...");
        sc.nextLine();
    }
}
