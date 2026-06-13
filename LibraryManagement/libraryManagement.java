package Librarymanagement;

import java.util.Scanner;

public class librarymanagement {

    public static void main(String[] args) {

        memberManager memberManager = new memberManager();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
                System.out.println("1.Add Member");
                System.out.println("2.Update Member");
                System.out.println("3.Remove Member");
                System.out.println("4.View All Members");
                System.out.println("5.Search Member");
                System.out.println("0.Exit");
                System.out.print("Your choice: ");
                
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    choice = -1;
                }
                
                switch (choice) {
                    case 1:
                        memberManager.addMember();
                        break;
                    case 2:
                        memberManager.updateMember();
                        break;
                    case 3:
                        memberManager.removeMember();
                        break;
                    case 4:
                        memberManager.viewAllMembers();
                        break;
                    case 5:
                        memberManager.searchMember();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                
            } while (choice != 0);
        }
    }
}