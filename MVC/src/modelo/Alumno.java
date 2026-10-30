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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean getTieneHijo() {
		return tieneHijo;
	}

	public void setTieneHijo(boolean tieneHijo) {
		this.tieneHijo = tieneHijo;
	}

	public int getIdEstudio() {
		return idEstudio;
	}

	public void setIdEstudio(int idEstudio) {
		this.idEstudio = idEstudio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
