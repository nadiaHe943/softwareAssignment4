package model.authentication;

public class Login {

	private String username;
	private String password;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean autheticate(String username, String password) {
		if (this.username.equals(username) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
