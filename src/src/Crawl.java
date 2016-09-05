import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by miteyan on 05/09/2016.
 */
public class Crawl {

    public static String savePage(String URL) throws IOException {
        String line ="", all = "";
        BufferedReader input = null;

        try{
            URL url = new URL(URL);
            input = new BufferedReader(new InputStreamReader(url.openStream()));

            while ( (line = input.readLine()) !=null) {
                all+="\n";
                all +=line;
            }

        } finally {
            if (input != null) {
                input.close();
            }
        }

        return all;
    }

    public static void printPage(String url) throws IOException {
        System.out.println(savePage(url));
    }

    public static void main (String[] args) throws IOException {
        printPage("http://miteyan.com");
    }

}
