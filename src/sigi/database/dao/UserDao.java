package sigi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
			String sql = "SELECT Username,Password FROM Users;";
		
			PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);
			
			ResultSet rs = this.dataSource.execute(ps);
			
			while(rs.next()) {
				UserDto user = new UserDto();
				user.setUserName(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
			/* 	user.SetProfile(rs.getString("Profile"));*/
			
				users.add(user);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return users;
	}

	public ArrayList<UserDto>getUser(){
		ArrayList<UserDto> myusers = new ArrayList<UserDto>();

		try{
			for (UserDto u:myusers) {
				String sql = "Insert into users(name,password) VALUES( ?, ?)";
				PreparedStatement ps= this.dataSource.getConection().prepareStatement(sql);
				ps.setString(1,"jonatan.cruz");
			    ps.setString(2,"Sunnychepill*" );
			    ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		 } return myusers;
	} 
	
	

	
	
}
