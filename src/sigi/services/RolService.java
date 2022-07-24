package sigi.services;
import java.util.ArrayList;

import sigi.database.dao.RolUDao;

import sigi.database.dto.RolUser;

import sigi.database.lib.DataSourceFactory;

public class RolService {
    private static RolService instance = null;

    private RolUDao rdao = null;

    ArrayList<RolUser> rol  = new ArrayList<RolUser>();

    private RolService(){}

    public static RolService getInstance(){
        if(!(instance instanceof RolService)){
            instance = new RolService();
        }
        return instance;
    }
    public void execute(){
        this.migrateRol();
    }

    public void migrateRol(){
        try{
            rdao = new RolUDao(DataSourceFactory.getDataSource("MySql"));

            rol = rdao.getListRol();
            
            for(RolUser rdto: rol){
                System.out.println("Name"+rdto.getNameRol()+"Display"+rdto.getDisplayName());
    
            }
        }catch(Exception e){
            e.printStackTrace();

        }
      
    }

}
