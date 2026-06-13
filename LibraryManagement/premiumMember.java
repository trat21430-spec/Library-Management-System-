package Librarymanagement;

public class premiumMember extends member {

    private static final int MAX_BORROW_LIMIT = 10;

    public premiumMember(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    public int getMaxBorrowLimit() {
        return 10;
    }

    @Override
    public String getMemberType() {
        return "Premium";
    }

    @Override
    public void displayInfo() {
        System.out.printf("%-10s %-20s %-15s %-25s %-5d %-15s%n",
                getId(), getName(), getPhone(), getEmail(),
                getBorrowedBooks(), getMemberType());
    }
}