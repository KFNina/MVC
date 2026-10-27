package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Alumno;

public class Conexion {
	String user = "root";
	String psw = "admin";

								//aca el puerto//aca va la bdd
	String path = "jdbc:mysql://localhost:3306/tpfinalpoo";
		
		
	public Connection conectar() {
		Connection c = null;
		try {
			//establece la conexion
			c = DriverManager.getConnection(path, user, psw);
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		return c;
	}
	
	public ArrayList<String> elementosComboBox() {
		ArrayList<String> elementos = new ArrayList<>();
		Connection c = conectar();
		
		String sql = "SELECT * FROM estudios";
		try {
			Statement stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				
				elementos.add(nombre);
			}
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		return elementos;
	}
	
	public void agregarAlumno(Alumno a) {
		
	}
}
