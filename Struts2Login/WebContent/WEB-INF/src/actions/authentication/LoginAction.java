package actions.authentication;

import com.opensymphony.xwork2.ActionSupport;

import model.authentication.Login;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//Data coming from the form, automatically injected by STRUTS
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//Default method invoked by STRUTS2
	public String execute() {
		//get reference to Login logic,
		//in this example create a Login object
		Login login = new Login("user","pwd");
		
		//execute the operation and return the result to STRUTS
		if (login.autheticate(username, password)) {
			return "success";
		} else {
			addActionError(getText("error.login"));
			return "error";
		}
		
	}
	
}
