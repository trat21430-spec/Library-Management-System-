package updatelibrarymanagementoop;

public class PremiumMember extends Member {

    private int borrowLimit;

    public PremiumMember(String id, String name, String phone, String email, int borrowLimit) {

        super(id, name, phone, email);
        this.borrowLimit = borrowLimit;
    }

    public int getBorrowLimit() {
        return this.borrowLimit;
    }

    @Override
    public String toString() {
        return super.toString() + " | Limit: " + this.borrowLimit;
    }
}
