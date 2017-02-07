/*
 * Kunal Patel
 * kunal.bharat.patel94@gmail.com
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;


public class RLMain {

    public static void main(String[] args) {

        try {
        	Scanner reader = new Scanner(System.in);  // Reading from System.in
        	String system = new String();
        	while(!(system.equals("PS4") || system.equals("XBOXONE") || system.equals("PC"))){
        		System.out.println("Enter your console (PS4, XboxOne, or PC): ");
        		system = reader.next();
        		system = system.toUpperCase();
        	}
        	
        	System.out.println("Enter your username: ");
        	String username = reader.next();
        	
        	if(system == "PC"){
        		system = new String("steam");
        	}
       	
        	StringBuilder link = new StringBuilder("https://rocketleaguestats.com/profile/" + system + "/" + username);

        	

            URL url;
            URLConnection uc;
            StringBuilder parsedContentFromUrl = new StringBuilder();
            String urlString=link.toString();
            System.out.println("Fetching stats for: " + username);
            url = new URL(urlString);
            uc = url.openConnection();
            uc.connect();
            uc = url.openConnection();
            uc.addRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            uc.getInputStream();
            BufferedInputStream in = new BufferedInputStream(uc.getInputStream());
            ArrayList<StringBuilder> lines = new ArrayList<StringBuilder>();
            int ch;
            StringBuilder pcF = new StringBuilder();
            StringBuilder str = new StringBuilder();
            while ((ch = in.read()) != -1) {
                if(ch != '\n'){
                    str.append((char)ch);
                }else{
                    lines.add(str);
                    str = new StringBuilder();
                }
                pcF.append((char)ch);

            }

            ArrayList<StringBuilder> sol = new ArrayList<StringBuilder>();
            for(int i = 0; i < 4; i++){
            	sol.add(new StringBuilder());
            }
            
            ArrayList<String> stats = new ArrayList<String>();

            
            
            int index = -1;
            for(int i = 0; i < lines.size(); i++){
            	StringBuilder s = lines.get(i);
            	if(s.toString().contains("h3")){
            		index++;
            		String rank = s.substring(
            				s.toString().indexOf('>', 30)+1,
            				s.toString().indexOf('<', 30));
            		StringBuilder sb = sol.get(index);
                    sb.append(rank + ": ");
            	}
            	
            	if(s.toString().contains("profile_tier-name")){
            		s = lines.get(i+1);
            		String ranking = s.substring(
            				s.toString().indexOf('>', 30)+1,
            				s.toString().indexOf('<', 30));
            		StringBuilder sb = sol.get(index);
            		if(ranking.equals("Unranked")){
                        sb.append(ranking);
            			continue;
            		}
                    sb.append(ranking + " - ");

            		s = lines.get(i+2);
            		String division = s.substring(
            				s.toString().indexOf('D', 0),
            				s.toString().indexOf('<', 0));       
                    sb.append(division + " ");
                    
            		s = lines.get(i+3);
            		s.append('@');
            		String rating = s.substring(
            				s.toString().indexOf('R', 0),
            				s.toString().indexOf('@', 0)); 
                    sb.append(rating);
            	}
            	
            	if(s.toString().contains("<tbody>")){
            		int wins_line = i+2;
            		String wins = lines.get(wins_line+6).toString();
            		wins = wins.trim();
            		wins = wins.substring(
            				wins.toString().indexOf('>', 0)+1,
            				wins.toString().indexOf('<', 2)); 
            		stats.add(new String("Wins: " + wins));
            		
            		String saves = lines.get(wins_line+7).toString();            		
            		saves = saves.trim();
            		saves = saves.substring(
            				saves.toString().indexOf('>', 0)+1,
            				saves.toString().indexOf('<', 2)); 
            		stats.add(new String("Saves: " + saves));

            		String MVPs = lines.get(wins_line+8).toString();
            		MVPs = MVPs.trim();
            		MVPs = MVPs.substring(
            				MVPs.toString().indexOf('>', 0)+1,
            				MVPs.toString().indexOf('<', 2)); 
            		stats.add(new String("MVPs: " + MVPs));

            		String MVPp = lines.get(wins_line+9).toString();
            		MVPp = MVPp.trim();
            		MVPp = MVPp.substring(
            				MVPp.toString().indexOf('>', 0)+1,
            				MVPp.toString().indexOf('<', 2)); 
            		stats.add(new String("MVP %: " + MVPp));

            		
            		String goals = lines.get(wins_line+18).toString();
            		goals = goals.trim();
            		goals = goals.substring(
            				goals.toString().indexOf('>', 0)+1,
            				goals.toString().indexOf('<', 2)); 
            		stats.add(new String("Goals: " + goals));

            		
            		String shots = lines.get(wins_line+19).toString();
            		shots = shots.trim();
            		shots = shots.substring(
            				shots.toString().indexOf('>', 0)+1,
            				shots.toString().indexOf('<', 2)); 
            		stats.add(new String("Shots: " + shots));

            		String assists = lines.get(wins_line+20).toString();
            		assists = assists.trim();
            		assists = assists.substring(
            				assists.toString().indexOf('>', 0)+1,
            				assists.toString().indexOf('<', 2)); 
            		stats.add(new String("Assists: " + assists));

            		String acc = lines.get(wins_line+21).toString();
            		acc = acc.trim();
            		acc = acc.substring(
            				acc.toString().indexOf('>', 0)+1,
            				acc.toString().indexOf('<', 2)); 
            		stats.add(new String("Shot Accuracy: " + acc));
            	
            	}
            	
            	
            	
            }
            
            for(StringBuilder s: sol){
            	System.out.println(s);
            }
            
            for(String s: stats){
            	System.out.println(s);
            }

 //           System.out.println(pcF);
        } catch (Exception Ex){
                System.out.println(Ex);
        }

    }




}
