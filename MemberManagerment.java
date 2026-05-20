/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package membermanagerment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class MemberManagerment {
 
    static Scanner sc = new Scanner(System.in);

    // DANH SÁCH DỮ LIỆU
    static ArrayList<String> memberIds = new ArrayList<>();
    static ArrayList<String> memberNames = new ArrayList<>();

    // =========================
    // ADD MEMBER
    // =========================
    public static void addMember() {

        System.out.println("\n----- ADD MEMBER -----");

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        // CHECK ID TRÙNG
        if(memberIds.contains(id)) {

            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        // THÊM DỮ LIỆU
        memberIds.add(id);
        memberNames.add(name);

        System.out.println("Added successfully.");
    }

    // =========================
    // VIEW MEMBERS
    // =========================
    public static void viewMembers() {

        System.out.println("\n----- MEMBER LIST -----");

        // KIỂM TRA DANH SÁCH RỖNG
        if(memberIds.isEmpty()) {

            System.out.println("No members found.");
            return;
        }

        // HIỂN THỊ DANH SÁCH
        for(int i = 0; i < memberIds.size(); i++) {

            System.out.println(
                    memberIds.get(i)
                    + " - "
                    + memberNames.get(i)
            );
        }
    }

    // =========================
    // UPDATE MEMBER
    // =========================
    public static void updateMember() {

        System.out.println("\n----- UPDATE MEMBER -----");

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        int index = memberIds.indexOf(id);

        // KHÔNG TÌM THẤY
        if(index == -1) {

            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();

        // CẬP NHẬT
        memberNames.set(index, newName);

        System.out.println("Updated successfully.");
    }

    // =========================
    // REMOVE MEMBER
    // =========================
    public static void removeMember() {

        System.out.println("\n----- REMOVE MEMBER -----");

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        int index = memberIds.indexOf(id);

        // KHÔNG TÌM THẤY
        if(index == -1) {

            System.out.println("Member not found.");
            return;
        }

        // XÓA DỮ LIỆU
        memberIds.remove(index);
        memberNames.remove(index);

        System.out.println("Removed successfully.");
    }

    // =========================
    // SEARCH MEMBER
    // =========================
    public static void searchMember() {

        System.out.println("\n----- SEARCH MEMBER -----");

        System.out.print("Enter ID or Name: ");

        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;

        for(int i = 0; i < memberIds.size(); i++) {

            if(memberIds.get(i).toLowerCase().contains(keyword)
                    ||
               memberNames.get(i).toLowerCase().contains(keyword)) {

                System.out.println(
                        memberIds.get(i)
                        + " - "
                        + memberNames.get(i)
                );

                found = true;
            }
        }

        // KHÔNG TÌM THẤY
        if(!found) {

            System.out.println("Member not found.");
        }
    }

    // =========================
    // MAIN MENU
    // =========================
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== MEMBER MANAGEMENT =====");

            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Update Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Search Member");
            System.out.println("0. Exit");

            System.out.print("Choose: ");

            choice = Integer.parseInt(sc.nextLine());

            switch(choice) {

                case 1:
                    addMember();
                    break;

                case 2:
                    viewMembers();
                    break;

                case 3:
                    updateMember();
                    break;

                case 4:
                    removeMember();
                    break;

                case 5:
                    searchMember();
                    break;

                case 0:
                    System.out.println("Exit Program.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 0);
    }
}