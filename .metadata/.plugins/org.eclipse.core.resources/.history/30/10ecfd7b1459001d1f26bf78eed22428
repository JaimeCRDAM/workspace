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
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\dam201\\Clases\\Asignaturas\\Acceso de datos\\Tema 2\\RecursosUnidad2\\Software\\sqlite-shell-win32-x86-3070900\\ejemplo.db");
			Statement statement = conexion.createStatement();
			ResultSet resul = statement.executeQuery("select * from departamentos");
			while(resul.next()) {
				System.out.println(resul.getInt(1) + " "+resul.getString(2)+" "+ resul.getString(3));
			}
            java.sql.DatabaseMetaData dbmd = conexion.getMetaData();
            
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            
            System.out.println("INFORMACION SOBRE LA BASE DE DATOS");
            System.out.println("=================================");
            System.out.println("Nombre: "+nombre);
            System.out.println("Driver: "+driver);
            System.out.println("Url: "+url);
            System.out.println("Usuario: "+usuario);
            
            ResultSet resul2 = null;
            resul2 = dbmd.getTables(null, "ejemplo", null, null);
            
            while(resul2.next()) {
            	String catalogo = resul2.getString("TABLE_CAT");
            	String esquema = resul2.getString("TABLE_SCHEM");
            	String tabla = resul2.getString("TABLE_NAME");
            	String tipo = resul2.getString("TABLE_TYPE");
            	String formatted = String.format("Tipo: %s, Catalogo: %s, Esquema: %s, Tabla: %s", tipo, catalogo, esquema, tabla);
            	System.out.println(formatted);
            }
            
            resul.close();
            resul2.close();
            conexion.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
