/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibraryManagement;

/**
 *
 * @author ACER
 */
public class regularMember extends member{

    public regularMember(String id, String name, String phone, String email, int borrowdBooks) {
        super(id, name, phone, email, borrowdBooks);
    }

    public regularMember(String id, String name, String phone, String email) {
        super(id, name, phone, email);
    }

    @Override
    public int gerBorrowlimit() {
     return 3;
    }
    
    
}
