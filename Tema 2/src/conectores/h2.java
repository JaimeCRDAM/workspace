package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class h2 {

	public static void main(String[] args) {
		try {
			// Cargar el driver de H2:
			Class.forName("org.h2.Driver");
			// Establecemos una conexión con la BD "ejemplo" que reside en D:\db\h2\ejemplo"
			Connection conexion = DriverManager.getConnection("jdbc:h2:C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\RecursosUnidad2\\Software\\h2\\ejemplo","sa","");
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
