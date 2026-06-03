/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementoop;

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
                System.out.println("Current Information:");
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
                System.out.println("Genre: " + b.getGenre());
                System.out.println("Publication Year: " + b.getYear());
                System.out.println("Quantity: " + b.getQuantity());
                System.out.print("New Title: ");
                b.setTitle(sc.nextLine());
                
               System.out.print("Enter new Title (leave blank to skip): ");
                String tempTitle = sc.nextLine();
                
                System.out.print("Enter new Author (leave blank to skip): ");
                String tempAuthor = sc.nextLine();
                
                System.out.print("Enter new Genre (leave blank to skip): ");
                String tempGenre = sc.nextLine();
                
                System.out.print("Enter new Publication Year (leave blank to skip): ");
                String tempYear = sc.nextLine();
                
                System.out.print("Enter new Quantity (leave blank to skip): ");
                String tempQty = sc.nextLine();
                System.out.print("[1] Update [2] Cancel: ");
                int confirm = sc.nextInt();
                sc.nextLine(); 
                
                if (confirm == 1) {
                    
                    if (!tempTitle.isEmpty()) b.setTitle(tempTitle);
                    if (!tempAuthor.isEmpty()) b.setAuthor(tempAuthor);
                    if (!tempGenre.isEmpty()) b.setGenre(tempGenre);
                    
                    
                    if (!tempYear.isEmpty()) {
                        b.setYear(Integer.parseInt(tempYear));
                    }
                    if (!tempQty.isEmpty()) {
                        b.setQuantity(Integer.parseInt(tempQty));
                    }
                    
                    System.out.println("Updated successfully!");
                } else {
                    System.out.println("Operation cancelled!");
                }
                return; 
            }
        }
        System.out.println("Book not found!");
    }
}
