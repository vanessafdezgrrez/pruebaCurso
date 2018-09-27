package model;

public class Cargo {

	private String iDCargo;
	private String descripcion;
	
	public Cargo() {
		this.iDCargo = "";
		this.descripcion = "";
	}
	
	public Cargo(String iDCargo, String descripcion) {
		super();
		this.iDCargo = iDCargo;
		this.descripcion = descripcion;
	}

	public String getiDCargo() {
		return iDCargo;
	}

	public void setiDCargo(String iDCargo) {
		this.iDCargo = iDCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Cargo [iDCargo=" + iDCargo + ", descripcion=" + descripcion + "]";
	}
	
}
