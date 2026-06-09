/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LOQ
 */
package librarymanagementoop;
import java.util.Scanner;
import java.util.ArrayList;

public class BooksService {

    public void addBooks(ArrayList<Books> bookList, Scanner sc) {
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

    public void updateBooks(ArrayList<Books> bookList, Scanner sc) {
        System.out.print("Enter ID to update: ");
        String findID = sc.nextLine();

        for (Books b : bookList) {
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

                    if (!tempTitle.isEmpty()) {
                        b.setTitle(tempTitle);
                    }
                    if (!tempAuthor.isEmpty()) {
                        b.setAuthor(tempAuthor);
                    }
                    if (!tempGenre.isEmpty()) {
                        b.setGenre(tempGenre);
                    }

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

    public void removeBooks(ArrayList<Books> bookList, Scanner sc) {

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

    public void searchBooks(ArrayList<Books> bookList, Scanner sc) {
        System.out.print("Enter a keyword: ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Books b : bookList) {
            if (b.getTitle().toLowerCase().contains(key)
                    || b.getAuthor().toLowerCase().contains(key)
                    || b.getGenre().toLowerCase().contains(key)) {
                System.out.println("- " + b.getTitle() + " (by " + b.getAuthor() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not found!");
        }
    }

    public void viewBooks(ArrayList<Books> bookList, Scanner sc) {
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
