
package sigi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import sigi.database.dto.VehiclesDto;
import sigi.database.lib.IDataSource;

public class VehiclesDao {
    
    private IDataSource dataSource = null;
   
    public VehiclesDao(IDataSource ds){
        this.dataSource = ds;
    }
    
    public void setDataSource(IDataSource ds){
        this.dataSource = ds;
    }
    public ArrayList<VehiclesDto>getListVehicles(){
    
         ArrayList<VehiclesDto> vehicle = new ArrayList<VehiclesDto>();
        try {
            String sql= "SELECT Brand, Model, LicensePlate, Alias, Description,Km FROM Vehicles ";
            
            PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);

            ResultSet rs = this.dataSource.execute(ps);
            
            

            while (rs.next()) {
                VehiclesDto vehicles = new VehiclesDto();
                vehicles.setBrand(rs.getString("Brand"));
                vehicles.setModel(rs.getString("Model"));
                vehicles.setLicenceP(rs.getString("LicensePlate"));
                vehicles.setAlias(rs.getString("Alias"));
                vehicles.setDescription(rs.getString("Description"));
                vehicles.setKm(rs.getLong("Km"));

                vehicle.add(vehicles);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    
    public boolean setVehicles(ArrayList<VehiclesDto> myvehicles){
        boolean flag=false;
        try {
            String sql = "Insert into vehicles(brand, model, license_plate, alias, description, km) VALUES ( ?, ?, ?, ?, ?, ?)";
            for(VehiclesDto v:myvehicles){
                PreparedStatement ps= this.dataSource.getConection().prepareStatement(sql);
                ps.setString(1, v.getBrand());
                ps.setString(2, v.getModel());
                ps.setString(3, v.getLicenceP());
                ps.setString(4, v.getAlias());
                ps.setString(5, v.getDescription());
                ps.setLong(6, v.getKm());
                ps.executeUpdate();
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
    }return flag;
}
}
