
package LibraryManagement;


public class prenimuMember extends member{

    public prenimuMember(String id, String name, String phone, String email, int borrowdBooks) {
        super(id, name, phone, email, borrowdBooks);
    }

    public prenimuMember(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    @Override
    public int gerBorrowlimit() {
      return 5;
    }
    
    
}
