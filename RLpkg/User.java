package RLpkg;

public class User {

	private String username;
	private String platform;
	
	User(){
		username = "";
		platform = "";
	}
	
	User(String u, String p){
		username = new String(u);
		platform = new String(p);
	}
	
	String getUser(){
		return this.username;
	}
	
	String getPlatform(){
		return this.platform;
	}
}
