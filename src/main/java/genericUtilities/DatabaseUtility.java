package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class DatabaseUtility implements IAutoConstants{
	Driver dbdriver;
	Connection connection;
	Statement statement;
	ResultSet result;
	//ArrayList list;

	/** This Method is used to establish Connection with DataBase
	 * @return void
	 */
	public void establishingDBConnection(){

		try {
			dbdriver=new Driver();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(DATABASE_URL, DATABASE_UN, DATABASE_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** This Method is used to read data from DataBase
	 * @param String DBQuery
	 * @param String columnName
	 */
	public ArrayList readingDatafromDB(String Query, String columnName1, String columnName2 ){
		ArrayList list= new ArrayList();
		try {
			 statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = statement.executeQuery(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next()){ 
				list.add(result.getString(columnName1)+"  "+ result.getString(columnName2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/** This Method is used to close the connection with DataBase
	 * 
	 */
	public void closingDBConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
