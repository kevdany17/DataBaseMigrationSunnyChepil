package sigi.database.lib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface IDataSource {
	
	Connection getConection();
	
	ResultSet execute(PreparedStatement query);
	
	ResultSet update(PreparedStatement query);
	
}
