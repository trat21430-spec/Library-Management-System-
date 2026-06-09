package com.mycompany.reportingoopjava;

import java.time.LocalDate;
import java.util.*;

// ================= BOOK =================
class Book {

    private String title;
    private int borrowCount;

    public Book(String title, int borrowCount) {
        this.title = title;
        this.borrowCount = borrowCount;
    }

    public String getTitle() {
        return title;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void increaseBorrowCount() {
        borrowCount++;
    }

    @Override
    public String toString() {
        return title + " | Borrowed: " + borrowCount + " times";
    }
}

// ================= MEMBER =================
class Member {

    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ================= TRANSACTION =================
class BorrowingTransaction {

    private Book book;
    private Member member;
    private LocalDate dueDate;
    private boolean returned;

    public BorrowingTransaction(
            Book book,
            Member member,
            LocalDate dueDate,
            boolean returned) {

        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public boolean isReturned() {
        return returned;
    }

    public boolean isOverdue() {
        return !returned
                && LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {

        return "Book: "
                + book.getTitle()
                + " | Member: "
                + member.getName();
    }
}

// ================= MAIN CLASS =================
public class reportingoopjava {

    private Scanner sc = new Scanner(System.in);

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<BorrowingTransaction> transactions =
            new ArrayList<>();

    // ================= MENU =================
    public void showMenu() {

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
    public void pressEnter() {

        System.out.print("\nPress Enter to continue...");
        sc.nextLine();
    }

    // ================= ADD BOOK =================
    public void addBook() {

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Borrow Count: ");
        int count = Integer.parseInt(sc.nextLine());

        books.add(new Book(title, count));

        System.out.println("Book added successfully!");
    }

    // ================= ADD MEMBER =================
    public void addMember() {

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members.add(new Member(name));

        System.out.println("Member added successfully!");
    }

    // ================= ADD TRANSACTION =================
    public void addTransaction() {

        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        if (members.isEmpty()) {
            System.out.println("No members available!");
            return;
        }

        System.out.println("\nAvailable Books:");

        for (int i = 0; i < books.size(); i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + books.get(i).getTitle());
        }

        System.out.print("Choose Book: ");
        int bookChoice =
                Integer.parseInt(sc.nextLine());

        System.out.println("\nAvailable Members:");

        for (int i = 0; i < members.size(); i++) {

            System.out.println(
                    (i + 1)
                    + ". "
                    + members.get(i).getName());
        }

        System.out.print("Choose Member: ");
        int memberChoice =
                Integer.parseInt(sc.nextLine());

        System.out.print("Returned (true/false): ");
        boolean returned =
                Boolean.parseBoolean(sc.nextLine());

        System.out.print("Due days from today: ");
        int days =
                Integer.parseInt(sc.nextLine());

        Book selectedBook =
                books.get(bookChoice - 1);

        Member selectedMember =
                members.get(memberChoice - 1);

        selectedBook.increaseBorrowCount();

        transactions.add(
                new BorrowingTransaction(
                        selectedBook,
                        selectedMember,
                        LocalDate.now().plusDays(days),
                        returned
                )
        );

        System.out.println(
                "Transaction added successfully!");
    }

    // ================= REPORT 1 =================
    public void currentBorrowedBooks() {

        System.out.println(
                "\n===== CURRENTLY BORROWED BOOKS =====");

        boolean found = false;

        for (BorrowingTransaction t : transactions) {

            if (!t.isReturned()) {

                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No borrowed books found.");
        }
    }

    // ================= REPORT 2 =================
    public void overdueBooks() {

        System.out.println(
                "\n===== OVERDUE BOOKS =====");

        boolean found = false;

        for (BorrowingTransaction t : transactions) {

            if (t.isOverdue()) {

                System.out.println(t);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No overdue books found.");
        }
    }

    // ================= REPORT 3 =================
    public void popularBooks() {

        System.out.println(
                "\n===== MOST POPULAR BOOKS =====");

        List<Book> sorted =
                new ArrayList<>(books);

        sorted.sort(
                (a, b) ->
                        b.getBorrowCount()
                        - a.getBorrowCount());

        for (Book b : sorted) {

            System.out.println(b);
        }
    }

    // ================= REPORT 4 =================
    public void topMembers() {

        System.out.println(
                "\n===== TOP BORROWING MEMBERS =====");

        Map<String, Integer> stats =
                new HashMap<>();

        for (BorrowingTransaction t : transactions) {

            String name =
                    t.getMember().getName();

            stats.put(
                    name,
                    stats.getOrDefault(name, 0) + 1
            );
        }

        stats.entrySet()
                .stream()
                .sorted(
                        (a, b) ->
                                b.getValue()
                                - a.getValue())
                .forEach(
                        entry ->
                                System.out.println(
                                        entry.getKey()
                                        + " | Total Borrowings: "
                                        + entry.getValue()
                                ));
    }

    // ================= RUN =================
    public void run() {

        int choice = 0;

        while (choice != 8) {

            showMenu();

            try {

                choice =
                        Integer.parseInt(
                                sc.nextLine());

                switch (choice) {

                    case 1:
                        addBook();
                        break;

                    case 2:
                        addMember();
                        break;

                    case 3:
                        addTransaction();
                        break;

                    case 4:
                        currentBorrowedBooks();
                        break;

                    case 5:
                        overdueBooks();
                        break;

                    case 6:
                        popularBooks();
                        break;

                    case 7:
                        topMembers();
                        break;

                    case 8:
                        System.out.println(
                                "\nThank you for using the system!");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice!");
                }

                if (choice != 8) {
                    pressEnter();
                }

            } catch (Exception e) {

                System.out.println(
                        "Invalid input!");
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        reportingoopjava app =
                new reportingoopjava();

        app.run();
    }
}
