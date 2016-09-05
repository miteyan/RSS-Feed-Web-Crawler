/**
 * Created by miteyan on 05/09/2016.
 */
public class Test {

    public static void main (String[] args){
        RSSitem i = new RSSitem("title","desc","link");
        Page p = new Page("Name","descipr",";ibk");
        System.out.println(new RSSfeed(p,i).getFeed());
    }
}
