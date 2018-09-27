package model;

public class Equipo {

	private String iDEquipo;
	private String iDProyecto;
	private String iDTrabajador;
	private String iDCargo;
	
	public Equipo() {
		super();
		this.iDEquipo = "";
		this.iDProyecto = "";
		this.iDTrabajador = "";
		this.iDCargo = "";
	}
	
	public Equipo(String iDEquipo, String iDProyecto, String iDTrabajador, String iDCargo) {
		super();
		this.iDEquipo = iDEquipo;
		this.iDProyecto = iDProyecto;
		this.iDTrabajador = iDTrabajador;
		this.iDCargo = iDCargo;
	}

	public String getiDEquipo() {
		return iDEquipo;
	}

	public void setiDEquipo(String iDEquipo) {
		this.iDEquipo = iDEquipo;
	}

	public String getiDProyecto() {
		return iDProyecto;
	}

	public void setiDProyecto(String iDProyecto) {
		this.iDProyecto = iDProyecto;
	}

	public String getiDTrabajador() {
		return iDTrabajador;
	}

	public void setiDTrabajador(String iDTrabajador) {
		this.iDTrabajador = iDTrabajador;
	}

	public String getiDCargo() {
		return iDCargo;
	}

	public void setiDCargo(String iDCargo) {
		this.iDCargo = iDCargo;
	}

	@Override
	public String toString() {
		return "Equipo [iDEquipo=" + iDEquipo + ", iDProyecto=" + iDProyecto + ", iDTrabajador=" + iDTrabajador
				+ ", iDCargo=" + iDCargo + "]";
	}
	
}
