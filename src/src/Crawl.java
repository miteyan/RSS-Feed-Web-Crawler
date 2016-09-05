import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by miteyan on 05/09/2016.
 */
public class Crawl {

    private static ArrayList<RSSitem> items = new ArrayList<RSSitem>();

    public ArrayList<RSSitem> getItems() {
        return items;
    }

    public static ArrayList<String > save(String URL) throws IOException {
        String line ="", all = "";
        BufferedReader input = null;

        ArrayList<String> strings = new ArrayList<String>();
        try{
            URL url = new URL(URL);
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while ( (line = input.readLine()) !=null) {
                all+="\n";
                all +=line;
                strings.add(line);
            }

        } finally {
            if (input != null) {
                input.close();
            }
        }
        return strings;
    }


    public static void print(ArrayList<String> a) {
        for (int i = 0; i<a.size(); i++) {
            System.out.println(i + " " +a.get(i));
        }
    }

    public static ArrayList  trimPage(String url, String keyword1, String keyword2) throws IOException {
        ArrayList<String> x = save(url);
        System.out.println(x.contains(keyword1));
        int f = x.indexOf(keyword1);
        System.out.println(x.contains(keyword2));
        int l = x.indexOf(keyword2);
        System.out.println(f + " " + l);
        int size = x.size();
        for (int i = 0; i<size-l; i++){
            x.remove(l);
        }
        for (int i = 0; i<f; i++){
            x.remove(0);
        }
        return x;
    }

    public static void crawl(ArrayList<String> lines) {
        int size = lines.size();
        int index = 0;
        String line = "";
        for (int i = 0 ; i < size ; i++ ) {
            line = lines.get(i);

            if (line.contains("title=")) {
                System.out.println("DESCRIPTION ADDED " +i);
                String desc = line.trim();
                String sub = desc.substring(desc.indexOf("title=\""), desc.indexOf("\" rel")).substring(7);
                items.add(new RSSitem(sub));
            }

            if (line.contains("<h4>")){
                System.out.println("TITLE ADDED " +i);

//                System.out.println("h4 "+i);
                String title = line.trim().substring(4, line.trim().length() - 5);
//                System.out.println(line.trim().substring(4,line.trim().length()-5));
                if (items.size()!=0){
                    items.get(index).setTitle(title);
                    items.get(index).setLink(index);
                    index++;
                }
            }


        }
    }



    public static void main (String[] args) throws IOException {
        String url = "http://miteyan.com";
        String keyword1 = "<!-- Portfolio Section -->";
        String keyword2 = "<!-- Experience Section -->";
        ArrayList<String> x = trimPage(url,keyword1,keyword2);
        print(x);
        crawl(x);
        System.out.println(items.size());
        for (int i =0 ; i<items.size(); i++) {
            System.out.println("Title " + items.get(i).getTitle() + " Description " + items.get(i).getDescription()+ " Link "+ items.get(i).getLink());
        }
    }
}