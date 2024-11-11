package VehicleProject;
import java.sql.*;
public class BikeRental {
   private int id;
   private String Bike_name;
   private String Bike_number;
   private static int deposit=3000;
   private int Bike_rental_amt;
   BikeRental(String name ,int id,String number,int amt)
   {
	   this.Bike_name=name;
	   this.id=id;
	   this.Bike_number=number;
	   this.Bike_rental_amt=amt;
   }
   BikeRental()
   {
	   this.Bike_name="adlg";
	   this.id=32;
	   this.Bike_number="adsf";
	   this.Bike_rental_amt=23;
   }
   public void insert() throws SQLException
   {
	   Connection con=DbConnection.getConnection();
	   PreparedStatement pst=con.prepareStatement("Insert into Bike values (?,?,?,?,?)");
	   pst.setInt(1, id);
	   pst.setString(2, Bike_name);
	   pst.setString(3, Bike_number);
	   pst.setInt(4, Bike_rental_amt);
	   pst.setBoolean(5, true);
	   pst.executeUpdate();
   }
   public void search(String bike) throws SQLException
   {
	   Connection con=DbConnection.getConnection();
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from Bike where Bike_name="+bike+"");
	  while(rs.next())
	  {
		  System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
	  }
   } 
   public void setdeposit(int amt)
   {
	   deposit=amt;
   }
   public void displayVehicle()
   {
	  Connection con;
	try {
		con = DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Bike");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getBoolean(5));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
   } 
   public boolean checkAvailability(int id) throws SQLException
   {
	   Connection con=DbConnection.getConnection();
		  Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from Bike where id="+id+"and Availability=true");
		  while(rs.next())
		  {
			  return true;
		  }
		  return false;
   }
   }

