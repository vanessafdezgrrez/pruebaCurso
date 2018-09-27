package controller;

import java.util.List;

/**
 * Para gestionar la funcionalidad de la ventana de trabajadores principalmente.
 */
public class CtrlTrabajador {
	
	private static String campoClave;

	/**
	 * Llamaremos al constructor de la clase que nos mostrar� la ventana de trabajadores.
	 * Tambi�n, obtendremos una lista con los nombres de los trabajadores gracias a otro m�todo de la capa
	 * l�gica con la que rellenaremos la lista de trabajadores que aparecer� en nuestra ventana.
	 */
	public static void inicio() {
		new view.FrmTrabajador();
		List<String> lst = logic.LogicTrabajador.getNombresTrabajador();
		for(String str : lst) {
			view.FrmTrabajador.lstTrab.add(str);
		}
	}

	/**
	 * Llamaremos al constructor de la ventana en la que incluiremos los datos necesarios para dar de alta un
	 * nuevo trabajador para que nos la muestre.
	 */
	public static void abrirNuevo() {
		new view.FrmNuevoTrabajador();
	}
	
	/**
	 * Obtendremos los datos inclu�dos por el usuario, los cuales ser�n inclu�dos en variables para llamar a
	 * otro m�todo para proceder a incluir el nuevo trabajador.
	 */
	public static void nuevoTrabajador() {
		String dni = view.FrmNuevoTrabajador.nuevoDNI.getText();
		String nombre = view.FrmNuevoTrabajador.nuevoNombre.getText();
		String apellidos = view.FrmNuevoTrabajador.nuevoApellidos.getText();
		String genero = view.FrmNuevoTrabajador.nuevoGenero.getText();
		logic.LogicTrabajador.nuevo(dni, nombre, apellidos, genero);
		inicio();
	}

	/**
	 * Obtendremos el �ndice del registro que pretendemos eliminar y con el que llamaremos a un m�todo para
	 * que elimine dicho registro.
	 */
	public static void borrar() {
		campoClave = logic.LogicTrabajador.listadoID.get(view.FrmTrabajador.lstTrab.getSelectedIndex());
		
		logic.LogicTrabajador.borrar(campoClave);
		inicio();
	}

	/**
	 * Tambi�n obtendremos el �ndice del registro que pretendemos editar llamando al constructor que nos
	 * mostrar� la ventana de editar donde se mostrar�n los campos actuales del mismo.
	 */
	public static void abrirEditar() {
		campoClave = logic.LogicTrabajador.listadoID.get(view.FrmTrabajador.lstTrab.getSelectedIndex());
		
		new view.FrmEditarTrabajador();
		
		view.FrmEditarTrabajador.editarDNI.setText(logic.LogicTrabajador.info("dni", campoClave));
		view.FrmEditarTrabajador.editarNombre.setText(logic.LogicTrabajador.info("nombre", campoClave));
		view.FrmEditarTrabajador.editarApellidos.setText(logic.LogicTrabajador.info("apellidos", campoClave));
		view.FrmEditarTrabajador.editarGenero.setText(logic.LogicTrabajador.info("genero", campoClave));
	}
	
	/**
	 * Tambi�n con el �ndice del registro a editar, pasaremos a variales los campos ya editados y llamaremos
	 * a otro m�todo al que se las pasaremos para su edici�n.
	 */
	public static void editar() {	
		campoClave = logic.LogicTrabajador.listadoID.get(view.FrmTrabajador.lstTrab.getSelectedIndex());
		
		String dni = view.FrmEditarTrabajador.editarDNI.getText();
		String nombre = view.FrmEditarTrabajador.editarNombre.getText();
		String apellidos = view.FrmEditarTrabajador.editarApellidos.getText();
		String genero = view.FrmEditarTrabajador.editarGenero.getText();
		
		logic.LogicTrabajador.editar(dni, nombre, apellidos, genero, campoClave);
		inicio();
	}

	/**
	 * Se har� referencia al constructor de la ventana de informaci�n del trabajador donde seguidamente y,
	 * mediante otro m�todo, se completar� con los campos almacenados.
	 */
	public static void abrirInfo() {
		new view.FrmInfoTrabajador();
		infoTrabajador();
	}

	/**
	 * Gracias al �ndice del registro del que queremos obtener informaci�n llamaremos a un m�todo para
	 * obtener cada uno de los campos almacenados que queremos mostrar.
	 */
	private static void infoTrabajador() {
		campoClave = logic.LogicTrabajador.listadoID.get(view.FrmTrabajador.lstTrab.getSelectedIndex());
		
		view.FrmInfoTrabajador.infoIDTrabajador.setText(logic.LogicTrabajador.info("id_trabajador", campoClave));
		view.FrmInfoTrabajador.infoDNI.setText(logic.LogicTrabajador.info("dni", campoClave));
		view.FrmInfoTrabajador.infoNombre.setText(logic.LogicTrabajador.info("nombre", campoClave));
		view.FrmInfoTrabajador.infoApellidos.setText(logic.LogicTrabajador.info("apellidos", campoClave));
		view.FrmInfoTrabajador.infoGenero.setText(logic.LogicTrabajador.info("genero", campoClave));
	}
	
}
