package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlite {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conexionsqlite = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\RecursosUnidad2\\Software\\sqlite-shell-win32-x86-3070900\\ejemplo.db");
			Statement statement = conexionsqlite.createStatement();
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
