package com.mycompany.reportingnonoop;

import java.util.*;

public class ReportingNonOOP {

    static Scanner sc = new Scanner(System.in);

    // Book Data
    static ArrayList<String> bookTitles = new ArrayList<>();
    static ArrayList<Integer> borrowCounts = new ArrayList<>();

    // Member Data
    static ArrayList<String> memberNames = new ArrayList<>();

    // Transaction Data
    static ArrayList<String> borrowedBooks = new ArrayList<>();
    static ArrayList<String> borrowers = new ArrayList<>();
    static ArrayList<Boolean> returnedList = new ArrayList<>();
    static ArrayList<Boolean> overdueList = new ArrayList<>();

    // ================= MENU =================
    public static void showMenu() {

        System.out.println("\n====================================");
        System.out.println("      LIBRARY REPORTING SYSTEM");
        System.out.println("====================================");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Add Borrowing Transaction");
        System.out.println("4. Currently Borrowed Books");
        System.out.println("5. Overdue Books");
        System.out.println("6. Most Popular Books");
        System.out.println("7. Top Borrowing Members");
        System.out.println("8. Exit");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");
    }

    // ================= PAUSE =================
    public static void pause() {

        System.out.print("\nPress Enter to continue...");
        sc.nextLine();
    }

    // ================= ADD BOOK =================
    public static void addBook() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Borrow Count: ");
        int count = Integer.parseInt(sc.nextLine());

        bookTitles.add(title);
        borrowCounts.add(count);

        System.out.println("Book added successfully!");
    }

    // ================= ADD MEMBER =================
    public static void addMember() {

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        memberNames.add(name);

        System.out.println("Member added successfully!");
    }

    // ================= ADD TRANSACTION =================
    public static void addTransaction() {

        if (bookTitles.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        if (memberNames.isEmpty()) {
            System.out.println("No members available!");
            return;
        }

        System.out.println("\nAvailable Books:");

        for (int i = 0; i < bookTitles.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + bookTitles.get(i));
        }

        System.out.print("Choose Book: ");
        int bookIndex =
                Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("\nAvailable Members:");

        for (int i = 0; i < memberNames.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + memberNames.get(i));
        }

        System.out.print("Choose Member: ");
        int memberIndex =
                Integer.parseInt(sc.nextLine()) - 1;

        System.out.print("Returned (true/false): ");
        boolean returned =
                Boolean.parseBoolean(sc.nextLine());

        System.out.print("Overdue (true/false): ");
        boolean overdue =
                Boolean.parseBoolean(sc.nextLine());

        borrowedBooks.add(bookTitles.get(bookIndex));
        borrowers.add(memberNames.get(memberIndex));
        returnedList.add(returned);
        overdueList.add(overdue);

        borrowCounts.set(
                bookIndex,
                borrowCounts.get(bookIndex) + 1
        );

        System.out.println(
                "Transaction added successfully!");
    }

    // ================= REPORT 1 =================
    public static void currentlyBorrowedBooks() {

        System.out.println(
                "\n===== CURRENTLY BORROWED BOOKS =====");

        boolean found = false;

        for (int i = 0; i < borrowedBooks.size(); i++) {

            if (!returnedList.get(i)) {

                System.out.println(
                        "Book: "
                                + borrowedBooks.get(i)
                                + " | Member: "
                                + borrowers.get(i)
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No borrowed books found.");
        }
    }

    // ================= REPORT 2 =================
    public static void overdueBooks() {

        System.out.println(
                "\n===== OVERDUE BOOKS =====");

        boolean found = false;

        for (int i = 0; i < borrowedBooks.size(); i++) {

            if (overdueList.get(i)) {

                System.out.println(
                        "Book: "
                                + borrowedBooks.get(i)
                                + " | Member: "
                                + borrowers.get(i)
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No overdue books found.");
        }
    }

    // ================= REPORT 3 =================
    public static void popularBooks() {

        System.out.println(
                "\n===== MOST POPULAR BOOKS =====");

        ArrayList<String> tempTitles =
                new ArrayList<>(bookTitles);

        ArrayList<Integer> tempCounts =
                new ArrayList<>(borrowCounts);

        for (int i = 0; i < tempCounts.size() - 1; i++) {

            for (int j = i + 1; j < tempCounts.size(); j++) {

                if (tempCounts.get(j)
                        > tempCounts.get(i)) {

                    int tempCount =
                            tempCounts.get(i);

                    tempCounts.set(
                            i,
                            tempCounts.get(j));

                    tempCounts.set(
                            j,
                            tempCount);

                    String tempTitle =
                            tempTitles.get(i);

                    tempTitles.set(
                            i,
                            tempTitles.get(j));

                    tempTitles.set(
                            j,
                            tempTitle);
                }
            }
        }

        for (int i = 0; i < tempTitles.size(); i++) {

            System.out.println(
                    tempTitles.get(i)
                            + " | Borrowed: "
                            + tempCounts.get(i)
                            + " times"
            );
        }
    }

    // ================= REPORT 4 =================
    public static void topBorrowingMembers() {

        System.out.println(
                "\n===== TOP BORROWING MEMBERS =====");

        HashMap<String, Integer> stats =
                new HashMap<>();

        for (String name : borrowers) {

            stats.put(
                    name,
                    stats.getOrDefault(
                            name,
                            0
                    ) + 1
            );
        }

        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(stats.entrySet());

        list.sort((a, b) ->
                b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                    entry.getKey()
                            + " | Total Borrowings: "
                            + entry.getValue()
            );
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        int choice;

        do {

            showMenu();

            try {

                choice =
                        Integer.parseInt(
                                sc.nextLine());

                switch (choice) {

                    case 1:
                        addBook();
                        pause();
                        break;

                    case 2:
                        addMember();
                        pause();
                        break;

                    case 3:
                        addTransaction();
                        pause();
                        break;

                    case 4:
                        currentlyBorrowedBooks();
                        pause();
                        break;

                    case 5:
                        overdueBooks();
                        pause();
                        break;

                    case 6:
                        popularBooks();
                        pause();
                        break;

                    case 7:
                        topBorrowingMembers();
                        pause();
                        break;

                    case 8:
                        System.out.println(
                                "\nThank you for using the system!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice!");
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid input!");
                choice = 0;
            }

        } while (choice != 8);
    }
}
