import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        String LastMessage = "";
        while (1==1){
            Thread.sleep(5000);
            String url = "https://smsreceivefree.com/info/18077009277/";
            Document document = Jsoup.connect(url).followRedirects(true).get();
            String Messages = document.select("td").text();
            for (Element element : document.select("tr:nth-child(1):contains(12505094XXX)")) {
                String finmess = removeTillWord(element.text(), "ago");
                System.out.println(finmess);
                System.out.println(LastMessage);
                if (!LastMessage.matches(finmess)){
                    System.out.println("okayyyy");
                    if (finmess.matches("ago first")){
                        System.out.println("first");
                        try {
                            Desktop.getDesktop().open(new File("C:/Users/Kaden/Desktop/DreamBotLauncher (1).jar"));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ScreenRegion s = new DesktopScreenRegion();
                        URL StartButton = new URL("http://i65.tinypic.com/2ihbaqe.png");
                        Target imageTarget = new ImageTarget(StartButton);
                        ScreenRegion r1 = s.wait(imageTarget, 3000);
                        org.sikuli.api.visual.Canvas canvas1 = new DesktopCanvas();
                        canvas1.addLabel(r1, "Clicking here").display(3);
                        Mouse mouse1 = new DesktopMouse();
                        mouse1.click(r1.getCenter());
                    }
                }
                LastMessage = finmess;
            }
        }
    }
    public static String removeTillWord(String input, String word) {
        return input.substring(input.indexOf(word));
    }
}