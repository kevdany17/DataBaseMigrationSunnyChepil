package sigi.database.dto;

public class UserDto {
	
	private String userName;
	
	private String password;

	private String email;
	


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
	
    public String getEmail(){
        return email;
    }
	
	public void setEmail(String email){
		this.email = email;
	}

    /*public String getEncriptPass() {
    	return BCrypt.gensalt();
    }
  public void setEncriptPass(String EncriptPass) {
	  this.EncriptPass = EncriptPass;
  }*/
}
