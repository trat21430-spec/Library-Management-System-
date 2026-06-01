package librarymanagementoop;

import java.util.ArrayList;
import java.util.Scanner;

public class memberManager {

    private ArrayList<member> memberList;
    private Scanner sc;

    public memberManager() {
        memberList = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // 1. Add new member
    public void addMember() {

        System.out.println("\n----------- ADD MEMBER -----------");

        System.out.print("Enter Member ID: ");
        String id = sc.nextLine();

        // Check duplicate ID
        if (findMemberById(id) != null) {
            System.out.println("Member ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        // Create member object
        member m = new member(id, name, phone, email);

        memberList.add(m);

        System.out.println("Member added successfully.");
    }

    // 2. Update member information
    public void updateMember() {

        System.out.println("\n----------- UPDATE MEMBER -----------");

        System.out.print("Enter Member ID: ");
        String id = sc.nextLine();

        member m = findMemberById(id);

        if (m == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println("Current Information:");
        m.displayInfo();

        System.out.print("Enter new name (blank to skip): ");
        String newName = sc.nextLine();

        System.out.print("Enter new phone (blank to skip): ");
        String newPhone = sc.nextLine();

        System.out.print("Enter new email (blank to skip): ");
        String newEmail = sc.nextLine();

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
    }

    // 3. Remove member
    public void removeMember() {

        System.out.println("\n----------- REMOVE MEMBER -----------");

        System.out.print("Enter Member ID: ");
        String id = sc.nextLine();

        member m = findMemberById(id);

        if (m == null) {
            System.out.println("Member not found.");
            return;
        }

        // Only remove if no borrowed books
        if (m.getBorrowedBooks() > 0) {
            System.out.println(
                    "Cannot remove member because borrowed books still exist.");
            return;
        }

        memberList.remove(m);

        System.out.println("Member removed successfully.");
    }

    // 4. View all members
    public void viewAllMembers() {

        System.out.println("\n----------- MEMBER LIST -----------");

        if (memberList.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        System.out.printf("%-10s %-20s %-15s %-25s %-5s\n",
                "ID", "Name", "Phone", "Email", "Book");

        for (member m : memberList) {
            m.displayInfo();
        }
    }

    // 5. Search member by name or ID
    public void searchMember() {

        System.out.println("\n----------- SEARCH MEMBER -----------");

        System.out.print("Enter Name or ID: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for (member m : memberList) {

            if (m.getId().toLowerCase().contains(keyword)
                    || m.getName().toLowerCase().contains(keyword)) {

                m.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No member found.");
        }
    }

    // Find member by ID
    public member findMemberById(String id) {

        for (member m : memberList) {

            if (m.getId().equalsIgnoreCase(id)) {
                return m;
            }
        }

        return null;
    }
}