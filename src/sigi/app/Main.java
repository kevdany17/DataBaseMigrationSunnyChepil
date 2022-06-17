package sigi.app;

import sigi.database.datasource.MySqlDataSourceImp;
import sigi.services.UserService;

public class Main {

	public static void main(String[] args) {
		//Run User Service
		System.out.println("**Execute Run User Migration**");
		var user = UserService.getInstance();
		user.execute();
	}
}
