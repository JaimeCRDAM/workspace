package conectores;

import java.sql.*;

public class mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver();
		
	}
	private static void puente() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//sun.jdbc.odbc.JdbcOdbcDriver
			Connection conexion = DriverManager.getConnection("jdbc:odbc:SQLServer","dam201","dam201");
			System.out.println("hola");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void driver() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.209.121;database=ASI1","dam201","dam201");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("select * from departamentos");
			while(result.next()) {
				System.out.println(result.getInt(1) + " "+result.getString(2)+" "+ result.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
