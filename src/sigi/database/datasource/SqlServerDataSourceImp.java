package sigi.database.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sigi.database.lib.IDataSource;

public class SqlServerDataSourceImp implements IDataSource{
	
	//Var Driver connection
	private Connection connection = null;
	
	//Vars Config connection
	private final String host = "localhost";
	
	private final String port = "1433";
	
	private final String database = "sunnyche_el3ctrify2";
	
	private final String user = "sa";
	
	private final String password = "Data_Base_90.A";
	
	
	//Singleton Pattern Implementation
	
	private static SqlServerDataSourceImp instance = null;

	private SqlServerDataSourceImp() {};
	
	public static SqlServerDataSourceImp getInstance() {
		if(!(instance instanceof SqlServerDataSourceImp)) {
			instance = new SqlServerDataSourceImp();
		}
		return instance;
	}
	
	//Interface Implementation
	@Override
	public Connection getConection() {
		String connectionUrl =
                "jdbc:sqlserver://"+this.host+":"+this.port+";"
                        + "database="+this.database+";"
                        + "user="+this.user+";"
                        + "password="+this.password+";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try{
        	this.connection = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection;
	}
	
	@Override
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
