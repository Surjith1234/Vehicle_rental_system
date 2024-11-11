package VehicleProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer {
    private String cus_name;
    private String cus_license_number;
    private String cus_phno;
    private int v_id;
    private String v_name;
    private String v_type;
    Customer()
    {
    	this.cus_name="surjith";
    	this.cus_license_number="tn-24 9999";
    	this.cus_phno="9080326477";
    	this.v_id=66;
    	this.v_name="bmw";	
    	this.v_type="car";
    }
    Customer(String name,String lice,String c_phno,int c_v_id,String v_name,String v_type) throws SQLException
    {
    	this.cus_name=name;
    	this.cus_license_number=lice;
    	this.cus_phno=c_phno;
    	this.v_id=c_v_id;
    	this.v_name=v_name;	
    	this.v_type=v_type;
    	insert();
    }
    public void insert() throws SQLException
    {
 	   Connection con=DbConnection.getConnection();
 	   PreparedStatement pst=con.prepareStatement("Insert into Customer values (?,?,?,?,?,?)");
 	   pst.setString(1, cus_name);
 	   pst.setString(2, cus_license_number);
 	   pst.setString(3, cus_phno);
 	   pst.setInt(4, v_id);
 	   pst.setString(5, v_name);
 	   pst.setString(1, v_type);
 	   pst.executeUpdate();
 	   updateVehicle();
    }
    public void updateVehicle() throws SQLException
    {
    	  Connection con=DbConnection.getConnection();
		  Statement st=con.createStatement();
		  st.executeUpdate("update "+v_type+" set Availability="+false+" from  where "+v_type+"_id="+v_id);
    }
    
}
