package Librarymanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class memberManager {

    private ArrayList<member> memberList;
    private Scanner sc;

    public memberManager() {
        this.memberList = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    // Add Member
    public void addMember() {
        try {
            System.out.println("\nADD MEMBER");

            System.out.print("Enter Member ID: ");
            String id = this.sc.nextLine().trim();

            if (id.isEmpty()) {
                System.out.println("Member ID cannot be empty.");
                return;
            }

            if (this.findMemberById(id) != null) {
                System.out.println("Member ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = this.sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter Phone: ");
            String phone = this.sc.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = this.sc.nextLine().trim();

            System.out.println("Choose Member Type:");
            System.out.println("1. Regular Member");
            System.out.println("2. Premium Member");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(sc.nextLine().trim());

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                return;
            }

            member m;

            if (choice == 1) {
                m = new regularMember(id, name, phone, email);
            } else {
                m = new premiumMember(id, name, phone, email);
            }

            this.memberList.add(m);
            System.out.println("Member added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for member type.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Member
    public void updateMember() {
        try {
            System.out.println("\nUPDATE MEMBER");

            System.out.print("Enter Member ID: ");
            String id = this.sc.nextLine().trim();

            member m = this.findMemberById(id);

            if (m == null) {
                System.out.println("Member not found.");
                return;
            }

            System.out.println("Current Information:");
            printHeader();
            m.displayInfo();

            System.out.print("Enter new Name (blank to skip): ");
            String newName = this.sc.nextLine().trim();

            System.out.print("Enter new Phone (blank to skip): ");
            String newPhone = this.sc.nextLine().trim();

            System.out.print("Enter new Email (blank to skip): ");
            String newEmail = this.sc.nextLine().trim();

            if (!newName.isEmpty()) {
                m.setName(newName);
            }

            if (!newPhone.isEmpty()) {
                m.setPhone(newPhone);
            }

            if (!newEmail.isEmpty()) {
                m.setEmail(newEmail);
            }

            System.out.println("Member updated successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Remove Member
    public void removeMember() {
        try {
            System.out.println("\nREMOVE MEMBER");

            System.out.print("Enter Member ID: ");
            String id = this.sc.nextLine().trim();

            member m = this.findMemberById(id);

            if (m == null) {
                System.out.println("Member not found.");
                return;
            }

            if (m.getBorrowedBooks() > 0) {
                System.out.println("Cannot remove member because borrowed books still exist.");
                return;
            }

            this.memberList.remove(m);
            System.out.println("Member removed successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View All Members
    public void viewAllMembers() {
        try {
            System.out.println("\nMEMBER LIST");

            if (this.memberList.isEmpty()) {
                System.out.println("No members found.");
                return;
            }

            printHeader();

            for (member m : this.memberList) {
                m.displayInfo();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search Member
    public void searchMember() {
        try {
            System.out.println("\nSEARCH MEMBER");

            System.out.print("Enter Name or ID: ");
            String keyword = this.sc.nextLine().trim().toLowerCase();

            if (keyword.isEmpty()) {
                System.out.println("Search keyword cannot be empty.");
                return;
            }

            boolean found = false;

            for (member m : this.memberList) {
                if (m.getId().toLowerCase().contains(keyword)
                        || m.getName().toLowerCase().contains(keyword)) {

                    if (!found) {
                        printHeader();
                    }

                    m.displayInfo();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No member found.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Find Member By ID
    public member findMemberById(String id) {
        for (member m : this.memberList) {
            if (m.getId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }

    // Print table header
    private void printHeader() {
        System.out.printf("%-10s %-20s %-15s %-25s %-5s %-15s%n",
                "ID", "Name", "Phone", "Email", "Books", "Type");
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
            System.out.println();
            
        }
    }

    // Get member list
    public ArrayList<member> getMemberList() {
        return memberList;
    }
}