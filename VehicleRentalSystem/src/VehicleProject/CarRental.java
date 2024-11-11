package VehicleProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRental {
	private int id;
	   private String car_name;
	   private String car_number;
	   private static int deposit=10000;
	   private int Car_rental_amt;
	   CarRental(String name ,int id,String number,int amt)
	   {
		   this.car_name=name;
		   this.id=id;
		   this.car_number=number;
		   this.Car_rental_amt=amt;
	   }
	   CarRental()
	   {
		   this.car_name="adlg";
		   this.id=32;
		   this.car_number="adsf";
		   this.Car_rental_amt=23;
	   }
	   public void insert() throws SQLException
	   {
		   Connection con=DbConnection.getConnection();
		   PreparedStatement pst=con.prepareStatement("Insert into Car values (?,?,?,?,?)");
		   pst.setInt(1, id);
		   pst.setString(2, car_name);
		   pst.setString(3, car_number);
		   pst.setInt(4, Car_rental_amt);
		   pst.setBoolean(5, true);
		   pst.executeUpdate();
	   }
	   public void search(String car) throws SQLException
	   {
		   Connection con=DbConnection.getConnection();
		  Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from Car where Car_name="+car+"");
		  while(rs.next())
		  {
			  System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		  }
	   } 
	   public void setdeposit(int amt)
	   {
		   deposit=amt;
	   }
	   public void displayVehicle() throws SQLException
	   {
		  Connection con=DbConnection.getConnection();
		  Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from Bike");
		  while(rs.next())
		  {
			  System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		  }
	   } 
	   public boolean checkAvailability(int id) throws SQLException
	   {
		   Connection con=DbConnection.getConnection();
			  Statement st=con.createStatement();
			  ResultSet rs=st.executeQuery("select * from Car where Car_id="+id);
			  while(rs.next())
			  {
				  return true;
			  }
			  return false;
	   }
}
