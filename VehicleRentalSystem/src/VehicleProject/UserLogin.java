package VehicleProject;
import java.sql.*;
public class UserLogin {
	private String mail_id;
	private String pass_word;
  UserLogin(String mail_id,String pass_word)
  {
	  this.mail_id=mail_id;
	  this.pass_word=pass_word;
  }
  public void insert() throws SQLException
  {
	  Connection con=DbConnection.getConnection();
	  String query="insert into Login values(?,?)";
	  PreparedStatement pst=con.prepareStatement(query);
	  pst.setString(1,mail_id);
	  pst.setString(2,pass_word);
	  pst.executeUpdate();
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
	return true;
  }
}
