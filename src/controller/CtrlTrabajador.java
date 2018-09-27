package controller;

import java.util.List;

/**
 * Para gestionar la funcionalidad de la ventana de trabajadores principalmente.
 */
public class CtrlTrabajador {
	
	private static String campoClave;

	/**
	 * Llamaremos al constructor de la clase que nos mostrará la ventana de trabajadores.
	 * También, obtendremos una lista con los nombres de los trabajadores gracias a otro método de la capa
	 * lógica con la que rellenaremos la lista de trabajadores que aparecerá en nuestra ventana.
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
	 * Obtendremos los datos incluídos por el usuario, los cuales serán incluídos en variables para llamar a
	 * otro método para proceder a incluir el nuevo trabajador.
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
	 * Obtendremos el índice del registro que pretendemos eliminar y con el que llamaremos a un método para
	 * que elimine dicho registro.
	 */
	public static void borrar() {
		campoClave = logic.LogicTrabajador.listadoID.get(view.FrmTrabajador.lstTrab.getSelectedIndex());
		
		logic.LogicTrabajador.borrar(campoClave);
		inicio();
	}

	/**
	 * También obtendremos el índice del registro que pretendemos editar llamando al constructor que nos
	 * mostrará la ventana de editar donde se mostrarán los campos actuales del mismo.
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
	 * También con el índice del registro a editar, pasaremos a variales los campos ya editados y llamaremos
	 * a otro método al que se las pasaremos para su edición.
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
	 * Se hará referencia al constructor de la ventana de información del trabajador donde seguidamente y,
	 * mediante otro método, se completará con los campos almacenados.
	 */
	public static void abrirInfo() {
		new view.FrmInfoTrabajador();
		infoTrabajador();
	}

	/**
	 * Gracias al índice del registro del que queremos obtener información llamaremos a un método para
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
