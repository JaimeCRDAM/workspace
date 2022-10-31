package conectores;

import java.sql.*;

public class oracle {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ejemplo","pw");
		Statement statement = conexion.createStatement();
		ResultSet resul = statement.executeQuery("select * from departamentos");
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
        resul2 = dbmd.getTables(null, "EJEMPLO", null, null);
        
        while(resul2.next()) {
        	String catalogo = resul2.getString("TABLE_CAT");
        	String esquema = resul2.getString("TABLE_SCHEM");
        	String tabla = resul2.getString("TABLE_NAME");
        	String tipo = resul2.getString("TABLE_TYPE");
        	String formatted = String.format("Tipo: %s, Catalogo: %s, Esquema: %s, Tabla: %s", tipo, catalogo, esquema, tabla);
        	System.out.println(formatted);
        }
        ResultSet pk = dbmd.getPrimaryKeys(null, "ejemplo", "departamentos");
        while(pk.next()) {
        	//System.out.println(pk.getString(columnLabel));
        }
        
        ResultSet ek = dbmd.getExportedKeys(null, "ejemplo", "departamentos");
        while(ek.next()) {
        	String ek_name = ek.getString("FKCOLUMN_NAME");
        	String pk_name = ek.getString("PKCOLUMN_NAME");
        	String pk_tablename = ek.getString("PKTABLE_NAME");
        	String ek_tablename = ek.getString("FKTABLE_NAME");
        	System.out.println(ek_tablename +" "+ek_name);
        	System.out.println(pk_tablename +" "+pk_name);
        }
        
        resul.close();
        resul2.close();
        conexion.close();
		while(resul.next()) {
			System.out.println(resul.getInt(1) + " "+resul.getString(2)+" "+ resul.getString(3));
		}
		}catch(Exception e) {
			
		}

	}

}
