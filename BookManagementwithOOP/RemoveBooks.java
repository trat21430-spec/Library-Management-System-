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
                bookList.remove(i);
                System.out.print("Successfully Remove!!");
                return;
            }
        }
        System.out.print("Books not found");
    }

   
}
