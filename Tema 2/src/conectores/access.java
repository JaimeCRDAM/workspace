package conectores;

import java.sql.*;

public class access {

	public static void main(String[] args) {
		try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\Access\\Departamentos.accdb");
		Statement statement = conexion.createStatement();
		ResultSet result = statement.executeQuery("select * from departamentos");
		while(result.next()) {
			System.out.println(result.getInt(1) + " "+result.getString(2)+" "+ result.getString(3));//asd
		}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}