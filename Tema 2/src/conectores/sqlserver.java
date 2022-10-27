package conectores;

import java.sql.*;

public class sqlserver {

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
			Connection conexion = DriverManager.getConnection("jdbc:sqlserver://192.168.209.213;database=ASI1","dam201","dam201");
			Statement statement = conexion.createStatement();
			ResultSet result = statement.executeQuery("select * from departamentos");
			while(result.next()) {
				System.out.println(result.getInt(1) + " "+result.getString(2)+" "+ result.getString(3));
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
	        String[] t = {"TABLE"};
	        resul2 = dbmd.getTables(null, null, null, t);
	        
	        while(resul2.next()) {
	        	String catalogo = resul2.getString("TABLE_CAT");
	        	String esquema = resul2.getString("TABLE_SCHEM");
	        	String tabla = resul2.getString("TABLE_NAME");
	        	String tipo = resul2.getString("TABLE_TYPE");
	        	String formatted = String.format("Tipo: %s, Catalogo: %s, Esquema: %s, Tabla: %s", tipo, catalogo, esquema, tabla);
	        	System.out.println(formatted);
	        }
	        
	        result.close();
	        resul2.close();
	        conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
