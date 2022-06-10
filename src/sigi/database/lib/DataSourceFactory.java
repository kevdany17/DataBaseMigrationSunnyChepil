package sigi.database.lib;

import sigi.database.datasource.SqlServerDataSourceImp;

public class DataSourceFactory {
	
	public static IDataSource getDataSource(String dataSource) throws Exception {
		switch(dataSource){
			case "SQLServer": return SqlServerDataSourceImp.getInstance(); 
			default: throw new Exception("factory not found");
		}
	}

}
