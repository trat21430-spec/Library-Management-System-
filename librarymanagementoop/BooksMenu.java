/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOQ
 */
package librarymanagementoop;
import java.util.ArrayList;
import java.util.Scanner;
public class BooksMenu {
    private ArrayList<Books> bookManageList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private BooksService bookService = new BooksService();

    public void start() {
        int choice;
        do {
            System.out.println("=========================");
            System.out.println("BOOK MANAGEMENT!!!");
            System.out.println("=========================");
            System.out.println("1-ADD BOOK");
            System.out.println("2-UPDATE BOOK");
            System.out.println("3-REMOVE BOOK");
            System.out.println("4-SEARCH BOOK");
            System.out.println("5-VIEW BOOK");
            System.out.println("0-EXIT!");
            System.out.println("--------------------------");
            System.out.print("Choose an option: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    bookService.addBooks(bookManageList, sc);
                    break;
                case 2:
                    bookService.updateBooks(bookManageList, sc);
                    break;
                case 3:
                    bookService.removeBooks(bookManageList, sc); 
                    break;
                case 4:
                    bookService.searchBooks(bookManageList, sc);
                    break;
                case 5:
                    bookService.viewBooks(bookManageList, sc);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }
        } while (choice != 0);
        
        sc.close(); 
    }
}
