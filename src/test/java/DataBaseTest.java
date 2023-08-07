import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBaseTest {

	@Test
	public void databaseRecords() throws SQLException {
		String port="3306";
		String host="localhost";
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from EmployeeInfo");
		while(rs.next()) {
		System.out.println(rs.getString("empName") + " " + rs.getString("location"));
//		System.out.print(rs.getString("location"));
	}}
	
}
