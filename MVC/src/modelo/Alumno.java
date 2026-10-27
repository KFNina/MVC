package modelo;
import java.time.*;
public class Alumno {
	private String nombre;
	private LocalDate fecha;
	private boolean tieneHijo;
	private int idEstudio;
	private String dni;
	
	public Alumno(String dni,String nombre, LocalDate fecha, boolean tieneHijo, int idEstudio) {
		this.dni = dni;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tieneHijo = tieneHijo;
		this.idEstudio = idEstudio;
	}
	
	
}
