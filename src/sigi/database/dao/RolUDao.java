package sigi.database.dao;
import sigi.database.dto.RolUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sigi.database.lib.IDataSource;
public class RolUDao {
   
    private IDataSource dataSource = null;

    public RolUDao(IDataSource ds){
        this.dataSource = ds;
    }
    public void setDataSource(IDataSource ds){
        this.dataSource = ds;
    }

    public ArrayList<RolUser> getListRol() {
    ArrayList<RolUser> rol = new ArrayList<RolUser>();
        try {
            String sql ="Select name,display_name from roles";
            PreparedStatement ps = this.dataSource.getConection().prepareStatement(sql);
            ResultSet rs = this.dataSource.execute(ps);
            
            while(rs.next()){
                RolUser role = new RolUser();
                role.setNameRol(rs.getString("name"));
                role.setDisplayName(rs.getString("display_name"));

                rol.add(role);
            }
        }catch(Exception e){
            e.printStackTrace();
    }
return rol;
    }
}
