/**
 * Created by miteyan on 05/09/2016.
 */
public class RSSfeed {



    public  RSSfeed(Page p, RSSitem i){
        addChannel(p);
        additem(i);
        finish();
    }

    private String rssfeed = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<rss version=\"2.0\">\n\n<channel>\n";

    public void addChannel(Page page){
        rssfeed +="\t<title>"+page.getTitle()+"</title>\n";
        rssfeed +="\t<link>"+page.getLink()+"</link>\n";
        rssfeed +="\t<description>"+page.getDescription()+"</description>\n\n";

    }

    public void additem(RSSitem item) {
        rssfeed+="\t<item>\n";
        rssfeed +="\t\t<title>"+item.getTitle()+"</title>\n";
        rssfeed +="\t\t<link>"+item.getLink()+"</link>\n";
        rssfeed +="\t\t<description>"+item.getDescription()+"</description>\n";
        rssfeed+="\t</item>\n\n";

    }
    private void finish(){
        rssfeed+="</channel>\n";
        rssfeed+="</rss>\n";
    }

    public String getFeed(){
        return rssfeed;
    }

}
