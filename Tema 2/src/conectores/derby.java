package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class derby {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\RecursosUnidad2\\Software\\db-derby-10.8.2.2-bin\\bin\\ejemplo");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("select * from departamentos");
			while(result.next()) {
				System.out.println(result.getInt(1) + " "+result.getString(2)+" "+ result.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
