package sigi.services;
import java.util.ArrayList;

import sigi.database.dao.VehiclesDao;
import sigi.database.dto.VehiclesDto;
import sigi.database.lib.DataSourceFactory;


public class VehiclesService {
    
    private static VehiclesService instance = null;

    private VehiclesDao dao = null;

    ArrayList<VehiclesDto> vehicle =  new ArrayList<VehiclesDto>();

    private VehiclesService(){}

    public static VehiclesService getInstance(){
        if(!(instance instanceof VehiclesService)){
            instance = new VehiclesService();
    }
    return instance;
}
   public void execute(){
    this.migrateVehicles();
    this.mymigrateVehicles();
   }

   public void migrateVehicles(){
    try {
        dao = new VehiclesDao(DataSourceFactory.getDataSource("SQLServer"));

        vehicle = dao.getListVehicles();
        
        for(VehiclesDto vdto:vehicle){
            System.out.println("Load--Brand "+vdto.getBrand()+" Model"+vdto.getModel()+" Licence"+vdto.getLicenceP()+" Alias"+vdto.getAlias()+" Description"+vdto.getDescription()+" KM"+vdto.getKm());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
   }

   public void mymigrateVehicles(){
    try {
        dao.setDataSource(DataSourceFactory.getDataSource("MySql"));
        if (dao.setVehicles(this.vehicle)) {
            System.out.println("Insersion con exito");
			 }else{
				System.out.println("Error ...");
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

   }
}