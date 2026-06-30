package updatelibrarymanagementoop;
public class Memberextends extends Personmember {

    public Memberextends(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Member: " + name;
    }
}