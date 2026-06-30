
package updatelibrarymanagementoop;

public class Document {

    private String id;
    private String title;

    public Document() {
    }

    public Document(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
