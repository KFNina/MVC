package bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		Connection c = conectar();
		
		String sql = "INSERT INTO personas(DNI,nombre,nacimiento,hijoas,idestudio)VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stat = c.prepareStatement(sql);
			
			Date fecha = Date.valueOf(a.getFecha());
			stat.setString(1, a.getDni());
			stat.setString(2, a.getNombre());
			stat.setDate(3, fecha);
			stat.setBoolean(4, a.getTieneHijo());
			stat.setInt(5, a.getIdEstudio());
			
			stat.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				c.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		
	}
}
