package Librarymanagement;

public class regularMember extends member {

    private static  int MAX_BORROW_LIMIT = 3;

    public regularMember(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    public String getMemberType() {
        return "Regular";
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-10s %-20s %-15s %-25s %-5d %-15s%n",
                getId(), getName(), getPhone(), getEmail(),
                getBorrowedBooks(), getMemberType());
    }
}