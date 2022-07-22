package sigi.database.datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sigi.database.lib.IDataSource;

public class MySqlDataSourceImp implements IDataSource {
    private Connection connection = null;

    private final String host = "localhost";

    private final String port = "3306";

    private final String database = "alfredo";

    private final String user = "root";
    
    private final String password = "12345";

    private static MySqlDataSourceImp instance = null;

    private  MySqlDataSourceImp (){};

    public static MySqlDataSourceImp getInstance(){
        if(!(instance instanceof MySqlDataSourceImp)){
            instance = new MySqlDataSourceImp();
        }
        return instance;
    }
    
   public Connection getConection(){
        
        String connectionUR1 =
        "jdbc:mysql://"+this.host+":"+this.port+"/"
                        +this.database
             
                       
                      ;

        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
        	this.connection = DriverManager.getConnection(connectionUR1,this.user,this.password);
        }
        catch ( ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
   }
   public ResultSet execute(PreparedStatement query) {
    try{
      
        ResultSet rs = query.executeQuery();
        return rs;
        
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
}

@Override
public ResultSet update(PreparedStatement query) {
    try{
       
        query.execute();
      
        ResultSet rs = query.getGeneratedKeys();
        
        return rs;
        
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
}

    }

