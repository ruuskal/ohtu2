package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.apache.http.client.fluent.Request;



public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        // System.out.println("json-muotoinen data:");
        // System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
   
        ArrayList <Player> finns = new ArrayList<>();
        for (Player player: players) {
            if (player.isFinn() == true) {
                finns.add(player);
            }
        }
        
        String s = "uuuuu";
        if (!s.matches("[a-z]*") || s.length() < 4) {
            System.out.println("HELLOOOOOO");
        }
        
        for (char c : s.toCharArray()) {
            if(!Character.isLetter(c)) {
                System.out.println("ei ole kirjain");
            }
        }
        
//        finns.sort(Comparator.comparing(Player::getPoints).reversed());
//        System.out.printf("%-30s%-12s%-12s%-12s\n", "Nimi ", "Maalit ", "Syötöt ", "Yhteensä");
//        for ( Player player : finns) {
//            System.out.printf("%-30s%-12d%-12d%-12d\n", player.getName(), player.getGoals(), 
//            player.getAssists(), player.getPoints() );
//        }
        



    }

  
}

