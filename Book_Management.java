 
import java.util.Scanner;

public class Book_Management {

    static Scanner sc = new Scanner(System.in);
    static String[] id = new String[100];
    static String[] tilte = new String[100];
    static String[] author = new String[100];
    static String[] genre = new String[100];
    static int[] year = new int[100];
    static int[] quantity = new int[100];
    static int count = 0;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("==BOOK MANAGEMENT==");
            System.out.println("1-Add book");
            System.out.println("2-Update book");
            System.out.println("3-Remove book");
            System.out.println("4-View book");
            System.out.println("5-Search book");
            System.out.println("0-Exit");

            System.out.println("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addbook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    searchBook();
                    break;
                case 0:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice");

            }

        } while (choice != 0);

    }

    static void viewBooks() {
        if (count == 0) {
            System.out.println("No books");
            return;
        }
        for (int i = 0; i < count; i++) {

            System.out.println("\nBook " + (i + 1));

            System.out.println("ID: " + id[i]);
            System.out.println("Title: " + tilte[i]);
            System.out.println("Author: " + author[i]);
            System.out.println("Genre: " + genre[i]);
            System.out.println("Year: " + year[i]);
            System.out.println("Quantity: " + quantity[i]);
        }
    }

    static void addbook() {
            System.out.print("ID: ");
            id[count] = sc.nextLine();
            System.out.print("Title: ");
            tilte[count] = sc.nextLine();
            System.out.print("Genre: ");
            genre[count] = sc.nextLine();
            System.out.print("Author: ");
            author[count] = sc.nextLine();
            System.out.print("year: ");
            year[count] = sc.nextInt();
            System.out.print("Quantity: ");
            quantity[count] = sc.nextInt();
            
            sc.nextLine();
            
            count++;
            System.out.print("Successfully added");
    }

    static void updateBook() {
        System.out.print("Enter ID: ");
        String  findID = sc.nextLine();
        for(int i = 0; i < count; i++){
            if( id[i].equals(findID)){
                System.out.print("New Title:");
                tilte[i] = sc.nextLine();
                System.out.print("New author: ");
                author[i] = sc.nextLine();
                System.out.print("New Genre: ");
                genre[i] = sc.nextLine();
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Book not found");
    }

    static void removeBook() {
        System.out.print("Enter ID: ");
        String findID = sc.nextLine();
        int pos = -1;
        for(int i = 0; i < count; i++){
            
            if(id[i].equals(findID)){
                pos = i;
                break;
            }
        }
        if(pos == -1){
            System.out.print("Book not found");
            return;
    }
        for(int i =pos; i< count - 1;i++){
            id[i] = id[i  + 1];
            author[i] = author[i + 1];
            tilte[i] = tilte[i + 1];
            genre[i] = genre[i + 1];
            year[i] = year[i + 1];
            quantity[i] = quantity[i + 1];
            
        }
        count --;
        System.out.print("Remove!");
}

    static void searchBook() {
        System.out.print("Enter a keyword: ");
        String key = sc.nextLine();
        
        boolean found = false;
        for(int i = 0; i < count ; i++){
            if(tilte[i].contains(key) ||author[i].contains(key)||genre[i].contains(key) ){
                System.out.println(tilte[i]);
                found = true;
                
            }
        }
        if(!found){
            System.out.print("Not found!");
        }
    }
}
