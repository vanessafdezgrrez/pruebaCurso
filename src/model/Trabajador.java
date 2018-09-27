package model;

public class Trabajador {

	private String iDTrabajador;
	private String dNI;
	private String nombre;
	private String apellidos;
	private String genero;
	
	public Trabajador() {
		this.iDTrabajador = "";
		this.dNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.genero = "";
	}
	
	public Trabajador(String iDTrabajador, String dNI, String nombre, String apellidos, String genero) {
		this.iDTrabajador = iDTrabajador;
		this.dNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
	}

	public String getiDTrabajador() {
		return iDTrabajador;
	}

	public void setiDTrabajador(String iDTrabajador) {
		this.iDTrabajador = iDTrabajador;
	}

	public String getdNI() {
		return dNI;
	}

	public void setdNI(String dNI) {
		this.dNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Trabajador [iDTrabajador=" + iDTrabajador + ", dNI=" + dNI + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", genero=" + genero + "]";
	}
	
}
