package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

class Member {

    String id;
    String name;
    String phone;
    String email;
    boolean borrowedBook;

    // Constructor
    public Member(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.borrowedBook = false;
    }

    // Display member information
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Borrowed Book: " + borrowedBook);
        System.out.println("----------------------");
    }
}

public class Mavenproject1 {

    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 1. Add member
    public static void addMember() {

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        members.add(new Member(id, name, phone, email));

        System.out.println("Member added successfully!");
    }

    // 2. Update member
    public static void updateMember() {

        System.out.print("Enter member ID to update: ");
        String id = sc.nextLine();

        for (Member m : members) {

            if (m.id.equalsIgnoreCase(id)) {

                System.out.print("New Name: ");
                m.name = sc.nextLine();

                System.out.print("New Phone: ");
                m.phone = sc.nextLine();

                System.out.print("New Email: ");
                m.email = sc.nextLine();

                System.out.println("Updated successfully!");
                return;
            }
        }

        System.out.println("Member not found!");
    }

    // 3. Remove member
    public static void removeMember() {

        System.out.print("Enter member ID to remove: ");
        String id = sc.nextLine();

        for (Member m : members) {

            if (m.id.equalsIgnoreCase(id)) {

                if (m.borrowedBook) {
                    System.out.println("Cannot remove! Member still borrowed books.");
                    return;
                }

                members.remove(m);

                System.out.println("Removed successfully!");
                return;
            }
        }

        System.out.println("Member not found!");
    }

    // 4. View all members
    public static void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member m : members) {
            m.display();
        }
    }

    // 5. Search member
    public static void searchMember() {

        System.out.print("Enter member name or ID: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (Member m : members) {

            if (m.id.equalsIgnoreCase(keyword)
                    || m.name.equalsIgnoreCase(keyword)) {

                m.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching member found.");
        }
    }

    // Main
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== MEMBER MANAGEMENT =====");
            System.out.println("1. Add new member");
            System.out.println("2. Update member");
            System.out.println("3. Remove member");
            System.out.println("4. View all members");
            System.out.println("5. Search member");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addMember();
                    break;

                case 2:
                    updateMember();
                    break;

                case 3:
                    removeMember();
                    break;

                case 4:
                    viewMembers();
                    break;

                case 5:
                    searchMember();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}