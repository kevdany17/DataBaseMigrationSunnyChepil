package sigi.services;

import java.util.ArrayList;

import sigi.database.dao.UserDao;
import sigi.database.dto.UserDto;
import sigi.database.lib.DataSourceFactory;

public class UserService {
	
	private static UserService instance = null;
	
	private UserDao dao = null;
	
	private UserService() {}
	
	public static UserService getInstance() {
		if(!(instance instanceof UserService)) {
			instance = new UserService();
		}
		return instance;
	}

	public void execute() {
		this.migrateUsers();
		
	}
	
	public void migrateUsers() {
		try {
			dao = new UserDao(DataSourceFactory.getDataSource("SQLServer"));
			
			ArrayList<UserDto> users = dao.getListUsers();
			
			for(UserDto dto: users) {
				System.out.println("Load: User -->"+dto.getUserName()+"\t Password -->"+dto.getPassword());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
