package librarymanagementoop;

import java.util.ArrayList;
import java.util.Scanner;

public class LibaryManagementOOP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create object manager
        memberManager manager = new memberManager();
        ArrayList<Books> bookManageList = new ArrayList<>();

        int choice;
        int choiceBook;
        do{
            System.out.println("=========================");
            System.out.println("BOOK MANAGEMENT!!!");
            System.out.println("=========================");
            System.out.println("1-ADD BOOK");
            System.out.println("2-UPDATE BOOK");
            System.out.println("3-REMOVE BOOK");
            System.out.println("4-SEARCH BOOK");
            System.out.println("5-VIEW BOOK");
            System.out.println("0-EXIT!");
            System.out.println("--------------------------");
            System.out.print("choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choiceBook){
                case 1:
                    AddBooks addAction = new AddBooks();
                    addAction.execute(bookManageList, sc);
                    break;
                case 2:
                    UpdateBooks updateAction = new UpdateBooks();
                    updateAction.execute(bookManageList, sc);
                    break;
                case 3:
                    RemoveBooks removeAction = new RemoveBooks();
                    removeAction.execute(sc, bookManageList);
                    break;
                case 4:
                    SearchBooks searchAction = new SearchBooks();
                    searchAction.execute(bookManageList, sc);
                    break;
                case 5:
                    ViewBooks viewAction = new ViewBooks();
                    viewAction.execute(bookManageList, sc);
            }
        }while(choice != 0);
      sc.close();
    }










        do {

            System.out.println("\n================================");
            System.out.println("      MEMBER MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Add New Member");
            System.out.println("2. Update Member");
            System.out.println("3. Remove Member");
            System.out.println("4. View All Members");
            System.out.println("5. Search Member");
            System.out.println("0. Exit");
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
                        System.out.println("Exit Program.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}