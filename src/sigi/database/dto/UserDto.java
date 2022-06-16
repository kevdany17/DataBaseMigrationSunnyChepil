package sigi.database.dto;

public class UserDto {
	
	private String userName;
	
	private String password;

   /*  private String profile;*/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public String getProfile(){
		return profile;
	}
	public void SetProfile(String profile){
		this.profile = profile;
	}	*/

}
