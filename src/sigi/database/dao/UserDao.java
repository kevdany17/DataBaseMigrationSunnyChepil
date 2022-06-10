package sigi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
		UserDto user = new UserDto();
		try{
			String sql = "SELECT TOP 2 Username,Password FROM Users;";
			
			PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);
			
			ResultSet rs = this.dataSource.execute(ps);
			
			while(rs.next()) {
				user.setUserName(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				users.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
