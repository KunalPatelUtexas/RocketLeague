package RLpkg;
/*
 * Kunal Patel
 * kunal.bharat.patel94@gmail.com
 */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.*;
import java.util.concurrent.*;

public class RLTracker {
	
	
	 public static void main(String[] args) {

	        	GUI RL_GUI = new GUI();
	        	String username = new String();
	        	String platform = new String();

        		while(!RL_GUI.Users.isEmpty()){
	        			User U = RL_GUI.Users.remove();
	        			System.out.println(U.getUser());
	        			RLBrowser T = new RLBrowser(U);
	        			T.run();
	        	}
	 }
	        
   
}
