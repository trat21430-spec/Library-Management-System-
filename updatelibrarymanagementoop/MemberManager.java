
package updatelibrarymanagementoop;

import java.util.ArrayList;

public class MemberManager {

    private ArrayList<Member> list = new ArrayList<>();

    public void add(Member m) {
        list.add(m);
    }

    public void show() {
        for (Member m : list) {
            System.out.println(m);
        }
    }

    public Member find(String id) {
        for (Member m : list) {
            if (m.getId().equalsIgnoreCase(id))
                return m;
        }
        return null;
    }

    public void update(String id, String name,
                       String phone, String email) {

        Member m = find(id);

        if (m != null) {
            m.setName(name);
            m.setPhone(phone);
            m.setEmail(email);
        }
    }

    public void delete(String id) {
        Member m = find(id);

        if (m != null)
            list.remove(m);
    }
}