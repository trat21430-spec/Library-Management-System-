package LibraryManagement;

public class premiumMember extends member {

    public premiumMember(String id, String name,
                         String phone, String email) {
        super(id, name, phone, email);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}