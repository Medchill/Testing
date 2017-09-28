import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import java.util.Map;

public class Login {
    public static void main(String[] args) throws Exception {
        Connection.Response initial = Jsoup.connect("https://textfree.us/#/login").method(Connection.Method.GET).execute();
        System.out.println(initial.toString());
        System.out.println("-------------------------------------------");
        Connection.Response login = Jsoup.connect("https://textfree.us/#/login").data("username", "Medchilled").data("password","Kasper1029").cookies(initial.cookies()).method(Connection.Method.POST).execute();
        System.out.println(login.toString());
        System.out.println("-------------------------------------------");
        Document page = Jsoup.connect("https://textfree.us/#/welcome").cookies(login.cookies()).get();
        System.out.println(page.text());
        System.out.println("-------------------------------------------");

        for (Element element : page.select(" :contains( )")) {
            System.out.println(element);
        }
    }
}