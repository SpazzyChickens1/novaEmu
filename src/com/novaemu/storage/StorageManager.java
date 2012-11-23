package com.novaemu.storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import com.mysql.jdbc.PreparedStatement;
import com.novaemu.utils.Logging;

public class StorageManager {

	BoneCP connectionPool = null;
	Connection connection = null;
	private Statement driverStatement;
	
	public StorageManager(String connectionString, String username, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			// setup the connection pool
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(connectionString); // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
			config.setUsername(username); 
			config.setPassword(password);
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			connectionPool = new BoneCP(config); // setup the connection pool
			
			connection = connectionPool.getConnection(); // fetch a connection
			this.driverStatement = getConnection().createStatement();
			
		} catch(Exception e) {
			Logging.Fatal("Failed to connect to the MySQL database, please check the configuration!");
			System.exit(0);
		}
	}
	
	public String readString(String query) 
	{	
		try 
		{
			ResultSet result = driverStatement.executeQuery(query);
			result.first();
			return result.getString(query.split(" ")[1]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Integer readInt32(String query)
	{	
		try
		{
			ResultSet result = driverStatement.executeQuery(query);
			result.first();
			return result.getInt(query.split(" ")[1]);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public PreparedStatement queryParams(String query)
	{
		try
		{
			return (PreparedStatement) getConnection().prepareStatement(query);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public void executeQuery(String query)
	{
		try
		{
			driverStatement.execute(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean entryExists(String query)
	{
		try 
		{
			ResultSet result = driverStatement.executeQuery(query);
			return result.next();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public Integer entryCount(String q)
	{
		int i = 0;

		try 
		{
			ResultSet resSet = driverStatement.executeQuery(q);

			while (resSet.next())
			{
				++i;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public Integer entryCount(PreparedStatement pStmt)
	{
		int i = 0;

		try 
		{
			ResultSet resSet = pStmt.executeQuery();

			while (resSet.next())
			{
				++i;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public ResultSet readRow(String Query)
	{
		try 
		{
			Statement stmt = getConnection().createStatement();
			ResultSet resSet = stmt.executeQuery(Query);

			while (resSet.next()) 
			{
				return resSet;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet readTable(String Query)
	{	
		try
		{	
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(Query);
			
			return result;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}
