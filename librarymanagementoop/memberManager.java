package librarymanagementoop;

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
            String id = this.sc.nextLine();

            if (this.findMemberById(id) != null) {
                System.out.println("Member ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = this.sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = this.sc.nextLine();

            System.out.print("Enter Email: ");
            String email = this.sc.nextLine();

            member m = new member(id, name, phone, email);

            this.memberList.add(m);

            System.out.println("Member added successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Member
    public void updateMember() {

        try {
            System.out.println("\nUPDATE MEMBER");

            System.out.print("Enter Member ID: ");
            String id = this.sc.nextLine();

            member m = this.findMemberById(id);

            if (m == null) {
                System.out.println("Member not found.");
                return;
            }

            System.out.println("Current Information:");
            m.displayInfo();

            System.out.print("Enter new Name (blank to skip): ");
            String newName = this.sc.nextLine();

            System.out.print("Enter new Phone (blank to skip): ");
            String newPhone = this.sc.nextLine();

            System.out.print("Enter new Email (blank to skip): ");
            String newEmail = this.sc.nextLine();

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
            String id = this.sc.nextLine();

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

            System.out.printf("%-10s %-20s %-15s %-25s %-5s%n",
                    "ID", "Name", "Phone", "Email", "Books");

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
            String keyword = this.sc.nextLine().toLowerCase();

            boolean found = false;

            for (member m : this.memberList) {

                if (m.getId().toLowerCase().contains(keyword)
                        || m.getName().toLowerCase().contains(keyword)) {

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
}
