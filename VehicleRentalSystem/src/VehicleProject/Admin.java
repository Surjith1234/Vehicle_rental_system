package VehicleProject;

import java.sql.*;

public class Admin {
	private String mail_id;
	private String pass_word;
  Admin(String mail_id,String pass_word)
  {
	  this.mail_id=mail_id;
	  this.pass_word=pass_word;
  }
  public boolean find() throws SQLException
  {
	  Connection con=DbConnection.getConnection();
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from Admin");
	  while(rs.next())
	  {
		  if(rs.getString(1).equals(mail_id)&&rs.getString(2).equals(pass_word))
		  {
			  return true;
		  }
	  }
	  return false;
  }
}
