package sigi.app;

import org.mindrot.jbcrypt.BCrypt;

import sigi.services.AccountingAService;
import sigi.services.RolService;
import sigi.services.UserService;
import sigi.services.VehiclesService;

public class Main {
	public static void main(String[] args) {
		
		//Run User Service
		System.out.println("**Execute Run User Migration**");
		var user = UserService.getInstance();
		var rolU = RolService.getInstance();
		var Accounting = AccountingAService.getInstance();
		var VehicleE = VehiclesService.getInstance();
		user.execute();
		/*rolU.execute();
		Accounting.execute();
		VehicleE.execute();*/
		
	}
}
