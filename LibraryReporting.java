package com.mycompany.libaryreporting;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryReporting {

    static Scanner sc = new Scanner(System.in);

    // ===== BOOK DATA =====
    static ArrayList<String> bookTitles = new ArrayList<>();
    static ArrayList<Integer> borrowCounts = new ArrayList<>();

    // ===== MEMBER DATA =====
    static ArrayList<String> memberNames = new ArrayList<>();
    static ArrayList<Integer> memberBorrowCounts = new ArrayList<>();

    // ===== BORROW DATA =====
    static ArrayList<String> borrowedBooks = new ArrayList<>();
    static ArrayList<Boolean> overdueStatus = new ArrayList<>();
    static ArrayList<Integer> overdueDays = new ArrayList<>();

    static final int FINE_PER_DAY = 5000;

    public static void main(String[] args) {

        sampleData();

        int choice;

        do {

            System.out.println("\n========== LIBRARY REPORTING SYSTEM ==========");
            System.out.println("1. View Currently Borrowed Books");
            System.out.println("2. View Overdue Books");
            System.out.println("3. View Most Popular Books");
            System.out.println("4. View Members With Most Borrowings");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    showBorrowedBooks();
                    break;

                case 2:
                    showOverdueBooks();
                    break;

                case 3:
                    showPopularBooks();
                    break;

                case 4:
                    showTopMembers();
                    break;

                case 0:
                    System.out.println("Program exited!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    // ====================================
    // SAMPLE DATA
    // ====================================
    static void sampleData() {

        // BOOKS
        bookTitles.add("Java Programming");
        borrowCounts.add(20);

        bookTitles.add("Database System");
        borrowCounts.add(12);

        bookTitles.add("Web Development");
        borrowCounts.add(30);

        // MEMBERS
        memberNames.add("Khoa");
        memberBorrowCounts.add(10);

        memberNames.add("An");
        memberBorrowCounts.add(7);

        memberNames.add("Minh");
        memberBorrowCounts.add(15);

        // BORROWED BOOKS
        borrowedBooks.add("Java Programming");
        overdueStatus.add(false);
        overdueDays.add(0);

        borrowedBooks.add("Database System");
        overdueStatus.add(true);
        overdueDays.add(4);

        borrowedBooks.add("Web Development");
        overdueStatus.add(true);
        overdueDays.add(2);
    }

    // ====================================
    // REPORT 1
    // CURRENTLY BORROWED BOOKS
    // ====================================
    static void showBorrowedBooks() {

        System.out.println("\n===== CURRENTLY BORROWED BOOKS =====");

        for (int i = 0; i < borrowedBooks.size(); i++) {

            System.out.println((i + 1) + ". " + borrowedBooks.get(i));
        }
    }

    // ====================================
    // REPORT 2
    // OVERDUE BOOKS
    // ====================================
    static void showOverdueBooks() {

        System.out.println("\n===== OVERDUE BOOKS =====");

        boolean found = false;

        for (int i = 0; i < borrowedBooks.size(); i++) {

            if (overdueStatus.get(i)) {

                int fine = overdueDays.get(i) * FINE_PER_DAY;

                System.out.println("Book: " + borrowedBooks.get(i));
                System.out.println("Overdue Days: " + overdueDays.get(i));
                System.out.println("Fine: " + fine + " VND");
                System.out.println("--------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No overdue books.");
        }
    }

    // ====================================
    // REPORT 3
    // MOST POPULAR BOOKS
    // ====================================
    static void showPopularBooks() {

        System.out.println("\n===== MOST POPULAR BOOKS =====");

        for (int i = 0; i < bookTitles.size(); i++) {

            System.out.println(bookTitles.get(i)
                    + " - Borrowed "
                    + borrowCounts.get(i)
                    + " times");
        }
    }

    // ====================================
    // REPORT 4
    // MEMBERS WITH MOST BORROWINGS
    // ====================================
    static void showTopMembers() {

        System.out.println("\n===== MEMBERS WITH MOST BORROWINGS =====");

        for (int i = 0; i < memberNames.size(); i++) {

            System.out.println(memberNames.get(i)
                    + " - Total Borrowings: "
                    + memberBorrowCounts.get(i));
        }
    }
}