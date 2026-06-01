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
    public void execute( ArrayList<Books> bookList, Scanner sc){
if ( bookList.isEmpty()){
System.out.print("No books found");
return;
}
int index = 1;
for( Books b : bookList){
System.out.print(" Book " + index++);
System.out.println("ID:  " + b.getID());
System.out.println("Title: " + b.getTitle());
System.out.println("Author: " + b.getAuthor());
System.out.println("Genre: " + b.getGenre());
System.out.println("Year: " + b.getYear());
System.out.println("Quantity: " +b.getQuantity());
}

    }
}
