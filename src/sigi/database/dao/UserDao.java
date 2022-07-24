package sigi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.mindrot.jbcrypt.*;
import sigi.database.dto.UserDto;
import sigi.database.lib.IDataSource;

public class UserDao {
	
	
	private IDataSource dataSource = null;
	public UserDao(IDataSource ds) {
		this.dataSource = ds;
	}
	
	public void setDataSource(IDataSource ds) {
		this.dataSource = ds;
	}
	
	
	public ArrayList<UserDto> getListUsers() {
		ArrayList<UserDto> users = new ArrayList<UserDto>();
		
		try{
			
		   
			String sql = "SELECT Username,Password,Email FROM Users;";
		
			PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);
			
			ResultSet rs = this.dataSource.execute(ps);
			
			
			while(rs.next()) {
				UserDto user = new UserDto();
				String hashed;
				hashed=BCrypt.hashpw("",BCrypt.gensalt());
				user.setUserName(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				
				user.setEmail(rs.getString("Email"));
			/* 	user.SetProfile(rs.getString("Profile"));*/
			user.setPassword(hashed);
				users.add(user);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	public boolean setUsers(ArrayList<UserDto> myusers){
		boolean flag = false;
		try{
			
			 
			 
			String sql = "Insert into users(name,password,email) VALUES( ?, ?,?)";
			for (UserDto u:myusers) {
			
				PreparedStatement ps= this.dataSource.getConection().prepareStatement(sql);
				
				ps.setString(1,u.getUserName());
			    ps.setString(2,u.getPassword());
				ps.setString(3, u.getEmail());
			    ps.executeUpdate();
			}
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return flag;
	} 
	
	

	
	
}
