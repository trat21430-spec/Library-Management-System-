package com.mycompany.libaryreporting;
import java.util.*;

public class LibraryReporting {

    public static void main(String[] args) {

        // Book Data
        String[] bookTitles = {
                "Java Programming",
                "Database Systems",
                "Operating System"
        };

        int[] borrowCounts = {
                5, 3, 7
        };

        // Member Data
        String[] memberNames = {
                "Khoa",
                "An"
        };

        // Borrowing Transactions
        String[] borrowedBooks = {
                "Java Programming",
                "Database Systems",
                "Operating System"
        };

        String[] borrowers = {
                "Khoa",
                "An",
                "Khoa"
        };

        boolean[] returned = {
                false,
                false,
                true
        };

        boolean[] overdue = {
                false,
                true,
                false
        };

        // REPORT 1
        System.out.println("\n===== CURRENTLY BORROWED BOOKS =====");

        for (int i = 0; i < borrowedBooks.length; i++) {
            if (!returned[i]) {
                System.out.println(
                        borrowedBooks[i]
                        + " | Borrowed by: "
                        + borrowers[i]
                );
            }
        }

        // REPORT 2
        System.out.println("\n===== OVERDUE BOOKS =====");

        for (int i = 0; i < borrowedBooks.length; i++) {
            if (overdue[i]) {
                System.out.println(
                        borrowedBooks[i]
                        + " | Borrowed by: "
                        + borrowers[i]
                );
            }
        }

        // REPORT 3
        System.out.println("\n===== MOST POPULAR BOOKS =====");

        for (int i = 0; i < bookTitles.length - 1; i++) {

            for (int j = i + 1; j < bookTitles.length; j++) {

                if (borrowCounts[j] > borrowCounts[i]) {

                    int tempCount = borrowCounts[i];
                    borrowCounts[i] = borrowCounts[j];
                    borrowCounts[j] = tempCount;

                    String tempTitle = bookTitles[i];
                    bookTitles[i] = bookTitles[j];
                    bookTitles[j] = tempTitle;
                }
            }
        }

        for (int i = 0; i < bookTitles.length; i++) {

            System.out.println(
                    bookTitles[i]
                    + " | Borrowed "
                    + borrowCounts[i]
                    + " times"
            );
        }

        // REPORT 4
        System.out.println("\n===== TOP BORROWING MEMBERS =====");

        Map<String, Integer> memberStats =
                new HashMap<>();

        for (String borrower : borrowers) {

            memberStats.put(
                    borrower,
                    memberStats.getOrDefault(
                            borrower,
                            0
                    ) + 1
            );
        }

        memberStats.entrySet()
                .stream()
                .sorted((a, b) ->
                        b.getValue() - a.getValue())
                .forEach(entry ->

                        System.out.println(
                                entry.getKey()
                                + " | Total Borrowings: "
                                + entry.getValue()
                        )
                );
    }
}
