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
		this.migrateMyUsers();
		
	}
	
	public void migrateUsers() {
		try {
			dao = new UserDao(DataSourceFactory.getDataSource("SQLServer"));
	
			
			ArrayList<UserDto> users = dao.getListUsers();
			
			
			for(UserDto dto: users) {
				System.out.println("Load: User -->"+dto.getUserName()+"password "+dto.getPassword()/*+" "+dto.getProfile()*/);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void migrateMyUsers(){
		try{
             dao = new UserDao(DataSourceFactory.getDataSource("MySql"));

			 ArrayList<UserDto> myusers = dao.getUser();

			 for (UserDto usedto : myusers) {
				System.out.println("Carga User"+usedto.getUserName()+"Pass"+usedto.getPassword());
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
