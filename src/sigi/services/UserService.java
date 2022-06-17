package sigi.services;

import java.util.ArrayList;

import sigi.database.dao.UserDao;
import sigi.database.dto.UserDto;
import sigi.database.lib.DataSourceFactory;

public class UserService {
	
	private static UserService instance = null;
	
	private UserDao dao = null;

	ArrayList<UserDto> users = new ArrayList<UserDto>();
	
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
	
			
			users = dao.getListUsers();
			
			
			for(UserDto dto: users) {
				System.out.println("Load: User -->"+dto.getUserName()+"password "+dto.getPassword()/*+" "+dto.getProfile()*/);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void migrateMyUsers(){
		try{
             dao.setDataSource(DataSourceFactory.getDataSource("MySql"));

			 if(dao.setUsers(this.users)){
				System.out.println("Insersion con exito");
			 }else{
				System.out.println("Error ...");
			 }

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
