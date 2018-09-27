package model;

public class Proyecto {

	private String iDProyecto;
	private String nombre;
	private Integer presupuesto;
	private String fechaInicio;
	private String fechaFin;
	
	public Proyecto() {
		this.iDProyecto = "";
		this.nombre = "";
		this.presupuesto = 0;
		this.fechaInicio = "";
		this.fechaFin = "";
	}
	
	public Proyecto(String iDProyecto, String nombre, Integer presupuesto, String fechaInicio, String fechaFin) {
		this.iDProyecto = iDProyecto;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getiDProyecto() {
		return iDProyecto;
	}

	public void setiDProyecto(String iDProyecto) {
		this.iDProyecto = iDProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Proyecto [iDProyecto=" + iDProyecto + ", nombre=" + nombre + ", presupuesto=" + presupuesto
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
}
