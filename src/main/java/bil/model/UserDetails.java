package bil.model;

public class UserDetails {
	protected String username;
	protected String password;
	protected String isuservalid;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String accesscode;
	protected String usercount;
	protected String isaccesscodevalid;

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccesscode() {
		return accesscode;
	}

	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}

	public String getUsercount() {
		return usercount;
	}

	public void setUsercount(String usercount) {
		this.usercount = usercount;
	}

	public String getIsaccesscodevalid() {
		return isaccesscodevalid;
	}

	public void setIsaccesscodevalid(String isaccesscodevalid) {
		this.isaccesscodevalid = isaccesscodevalid;
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

	public String getIsuservalid() {
		return isuservalid;
	}

	public void setIsuservalid(String isuservalid) {
		this.isuservalid = isuservalid;
	}

}
