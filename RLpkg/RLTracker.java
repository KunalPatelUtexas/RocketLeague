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
    	while(RL_GUI.Users.size() <= 10){
			while(!RL_GUI.Users.isEmpty()){
	    			User U = RL_GUI.Users.remove();
	    			RLBrowser RL = new RLBrowser(U);
	    			RL.run();
	    	}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
	 }
	 
}
