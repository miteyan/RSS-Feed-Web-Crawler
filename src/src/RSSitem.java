/**
 * Created by miteyan on 05/09/2016.
 */
public class RSSitem {

    private String title;
    private String link;
    private String description;

    public RSSitem(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public RSSitem(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(int index) {
       this.link = "http://miteyan.com/#prettyPhoto/" +Integer.toString(index);
    }

}
