package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSQLDB {

	public static void main(String[] args) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			// Establecemos una conexión con la BD "ejemplo" que reside en D:/hsqldb/data/ejemplo"
			Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\RecursosUnidad2\\Software\\hsqldb-2.2.6\\hsqldb\\data\\ejemplo\\ejemplo", "sa", "");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("select * from PUBLIC.DEPARTAMENTOS");
			while(result.next()) {
				System.out.println(result.getInt(1) + " "+result.getString(2)+" "+ result.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
