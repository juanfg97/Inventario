package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
//Se hace la conexion 
	Connection cx=null;
//metodo conectar
	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			cx=DriverManager.getConnection("jdbc:sqlite:inventario.db");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}
	//metodo desconectar
	public void desconectar() {
		try {
			cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
