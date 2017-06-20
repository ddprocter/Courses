package lifetracker;

import java.io.Serializable;

public class User implements Serializable {
	
	private String userLogin;
	private char[] password;
	private boolean isLoggedIn = false;
	private String passwordString;
	
	
	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public User(){
		
	}
	
	public boolean login(String user, char[] password){
		
		this.userLogin = user;
		this.password = password;
		this.passwordString = new String(password);
		// to do: move to file based user/password login
		if (userLogin.equals("d") && passwordString.equals("p")) {
			this.isLoggedIn = true;
			return true;
		}
		if (userLogin.equals("r") && passwordString.equals("g")) {
			this.isLoggedIn = true;
			return true;
		}
		if (userLogin.equals("demo") && passwordString.equals("demo")) {
			this.isLoggedIn = true;
			return true;
		}
		
		return false;
	
	}

}
