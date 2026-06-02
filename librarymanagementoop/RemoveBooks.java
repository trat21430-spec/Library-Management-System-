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
public class RemoveBooks {

    public void execute(Scanner sc, ArrayList<Books> bookList) {
        System.out.print("Enter ID: ");
        String findID = sc.nextLine();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getID().equals(findID)) {

                System.out.println("Found book: " + bookList.get(i).getTitle());
                System.out.print("[1] Delete [2] Cancel: ");
                int confirm = sc.nextInt();
                sc.nextLine();

                if (confirm == 1) {
                    bookList.remove(i);
                    System.out.println("Removed successfully!");
                } else {
                    System.out.println("Operation cancelled!");
                }
                return;
            }
        }
        System.out.print("Books not found");
    }

}
