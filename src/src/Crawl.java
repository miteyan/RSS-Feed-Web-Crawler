import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by miteyan on 05/09/2016.
 */
public class Crawl {

    public static String savePage(String URL) throws IOException {
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
        return all;
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

    public static void printPage(String url) throws IOException {
        System.out.println(savePage(url));
    }

    public static void print(ArrayList<String> a) {
        for (int i = 0; i<a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
    public static void main (String[] args) throws IOException {
        String url = "http://miteyan.com";

        ArrayList<String> x = save(url);
        System.out.println(x.contains("<!-- Portfolio Section -->"));
        print(save(url));

//        printPage(url);
//        printPage(trimPage(url));


    }

    public static String trimPage(String url) throws IOException {
        String page = savePage(url);
        String line = "";
        String trimmed = "";
        Scanner scanner = new Scanner(page);
        while (scanner.hasNext()) {
            System.out.println("X");
            while ( (line = scanner.nextLine()) !="<!-- Portfolio Section -->") {
                System.out.println("Not found");
            }
            trimmed +=scanner.nextLine();
        }
        return trimmed;
    }

}
