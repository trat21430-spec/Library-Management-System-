package librarymanagementoop;

import java.util.Scanner;

public class LibraryanagementOOP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Member Management");
            System.out.println("2. Book Management");
            System.out.println("3. Reporting");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        runMemberManagement();
                        break;

                    case 2:
                        BooksMenu menu = new BooksMenu();
                        menu.start();
                        break;

                    case 3:
                        reportingoopjava report =
                                new reportingoopjava();
                        report.run();
                        break;

                    case 0:
                        System.out.println("Exit Program!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }

    // Member Management Menu
    public static void runMemberManagement() {

        Scanner sc = new Scanner(System.in);
        memberManager manager = new memberManager();
        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("      MEMBER MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Add New Member");
            System.out.println("2. Update Member");
            System.out.println("3. Remove Member");
            System.out.println("4. View All Members");
            System.out.println("5. Search Member");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            try {

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        manager.addMember();
                        break;

                    case 2:
                        manager.updateMember();
                        break;

                    case 3:
                        manager.removeMember();
                        break;

                    case 4:
                        manager.viewAllMembers();
                        break;

                    case 5:
                        manager.searchMember();
                        break;

                    case 0:
                        System.out.println("Back to Main Menu.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = -1;
            }

        } while (choice != 0);
    }
}