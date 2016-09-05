import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by miteyan on 05/09/2016.
 */
public class Test {

    public static void main (String[] args) throws IOException {

        Crawl c = new Crawl();
        String url = "http://miteyan.com";
        String keyword1 = "<!-- Portfolio Section -->";
        String keyword2 = "<!-- Experience Section -->";
        ArrayList<String> x = c.trimPage(url, keyword1, keyword2);
        c.crawl(x);
        ArrayList<RSSitem> items = c.getItems();

        for (int i =0 ; i<items.size(); i ++) {
            System.out.println("Title " + items.get(i).getTitle() + " Description " + items.get(i).getDescription()+ " Link "+ items.get(i).getLink());
        }
        System.out.println();

        Page p = new Page("my website","personal website","miteyan.com");
        RSSfeed feed = new RSSfeed(p,items);
        System.out.println(feed.getFeed());
    }
}
