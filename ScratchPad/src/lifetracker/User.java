package lifetracker;

public class User {
	
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
		System.out.println(passwordString);
		
		if (userLogin.equals("dprocter") && passwordString.equals("1234")) {
			this.isLoggedIn = true;
			return true;
		} else {
			return false;
		}
		
	}

}
