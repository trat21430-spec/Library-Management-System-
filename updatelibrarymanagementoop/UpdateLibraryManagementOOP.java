package updatelibrarymanagementoop;

public class UpdateLibraryManagementOOP {

    public static void main(String[] args) {

        MemberManager manager = new MemberManager();

        manager.add(new Member("M01", "TRA", "0123", "tra@gmail.com"));

        manager.add(new PremiumMember(
                "M02",
                "HUY",
                "0999",
                "huy@gmail.com",
                5));

        manager.show();
    }

}
