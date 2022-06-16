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
    
    private final String password = "";

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
        "jdbc:sqlserver://"+this.host+":"+this.port+";"
                        + "database="+this.database+";"
                        + "user="+this.user+";"
                        + "password="+this.password+";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try{
        	this.connection = DriverManager.getConnection(connectionUR1);
        }
        catch (SQLException e) {
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

