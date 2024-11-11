package VehicleProject;
import java.sql.*;
public class DbConnection {
	private static String url="jdbc:mysql://localhost:3306/vehicleRentalSystem";
	private static String username="root";
	private static String password="Surjith@123"; 
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,username,password);
	}
}
 