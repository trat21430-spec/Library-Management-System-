
import java.time.LocalDate;
import java.util.*;

class Book {

    private final String title;
    private final int borrowCount;

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

    @Override
    public String toString() {
        return title + " | Borrowed: "
                + borrowCount + " times";
    }
}

class Member {

    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class BorrowingTransaction {

    private final Book book;
    private final Member member;
    private final LocalDate dueDate;
    private final boolean returned;

    public BorrowingTransaction(Book book,
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
        return !returned &&
                LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {

        return "Book: " + book.getTitle()
                + " | Member: "
                + member.getName();
    }
}

public class reportingoop {

    public static void main(String[] args) {

        // BOOKS
        Book b1 = new Book(
                "Java Programming", 5);

        Book b2 = new Book(
                "Database Systems", 3);

        Book b3 = new Book(
                "Operating System", 7);

        // MEMBERS
        Member m1 = new Member("Khoa");
        Member m2 = new Member("An");

        // LIST BOOKS
        List<Book> books = new ArrayList<>();

        books.add(b1);
        books.add(b2);
        books.add(b3);

        // TRANSACTIONS
        List<BorrowingTransaction> transactions =
                new ArrayList<>();

        transactions.add(
                new BorrowingTransaction(
                        b1,
                        m1,
                        LocalDate.now().plusDays(3),
                        false
                )
        );

        transactions.add(
                new BorrowingTransaction(
                        b2,
                        m2,
                        LocalDate.now().minusDays(2),
                        false
                )
        );

        transactions.add(
                new BorrowingTransaction(
                        b3,
                        m1,
                        LocalDate.now().plusDays(5),
                        true
                )
        );

        // REPORT 1
        System.out.println(
                "\n===== CURRENTLY BORROWED BOOKS ====="
        );

        for (BorrowingTransaction t : transactions) {

            if (!t.isReturned()) {
                System.out.println(t);
            }
        }

        // REPORT 2
        System.out.println(
                "\n===== OVERDUE BOOKS ====="
        );

        for (BorrowingTransaction t : transactions) {

            if (t.isOverdue()) {
                System.out.println(t);
            }
        }

     
        System.out.println(
                "\n===== MOST POPULAR BOOKS ====="
        );

        books.sort((x, y) ->
                y.getBorrowCount()
                        - x.getBorrowCount());

        for (Book b : books) {
            System.out.println(b);
        }

        // REPORT 4
        System.out.println(
                "\n===== TOP BORROWING MEMBERS ====="
        );

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

        
        
        