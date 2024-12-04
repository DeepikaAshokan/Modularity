package testData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;

public class DatabaseHelper {

	String sqlQuery1 = "SELECT * FROM departments";

	public void fetchdbdata() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sqlQuery1);
		while (result.next()) {
			System.out.print(result.getInt(1) + " ");
			System.out.print(result.getString(2) + " ");
			System.out.print(result.getString(3) + " ");
			System.out.println();
		}
	}

	String sqlQuery2 = "Select * from studentsdetails1 where LASTNAME = 'ARUN'";

	List<String> UserDetails = new ArrayList<String>();

	public List<String> fetchdbData1() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sqlQuery2);
		while (result.next()) {

			UserDetails.add(result.getString(1));
			UserDetails.add(result.getString(2));
			UserDetails.add(result.getString(3));
			UserDetails.add(result.getString(4));
			UserDetails.add(result.getString(5));

			System.out.print(result.getString(1) + " ");
			System.out.print(result.getString(2) + " ");
			System.out.print(result.getString(3) + " ");
			System.out.print(result.getString(4) + " ");
			System.out.print(result.getString(5) + " ");
			System.out.println();

		}
		return UserDetails;
	}

	String sqlQuery3 = "SELECT * FROM EMPLOYEE01";

	public void task() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/COLLEGE", "root", "password");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sqlQuery3);

		int rowcount = 0;

		while (result.next()) {
			System.out.print(result.getInt(1) + " ");
			System.out.print(result.getString(2) + " ");
			System.out.print(result.getInt(3) + " ");
			System.out.print(result.getInt(4) + " ");

			System.out.println();
			++rowcount;
		}
		System.out.println("Total number of records: " + rowcount);
	}

}
