package controller;

import java.util.List;

/**
 * Para gestionar la funcionalidad de la ventana de proyectos principalmente.
 */
public class CtrlProyecto {
	
	public static List<String> lst;
	private static String campoClave;

	/**
	 * Llamaremos al constructor de la clase que nos mostrar� la ventana de proyectos.
	 * Tambi�n, obtendremos una lista con los nombres de los proyectos gracias a otro m�todo de la capa l�gica
	 * con la que rellenaremos la lista de proyectos que aparecer� en nuestra ventana.
	 */
	public static void inicio() {
		new view.FrmProyecto();
		lst = logic.LogicProyectos.getNombresProyecto();
		for(String str : lst) {
			view.FrmProyecto.lstProy.add(str);
		}
	}

	/**
	 * Llamaremos al constructor de la ventana en la que incluiremos los datos necesarios para dar de alta un
	 * nuevo proyecto para que nos la muestre.
	 */
	public static void abrirNuevo() {
		new view.FrmNuevoProyecto();
	}

	/**
	 * Obtendremos los datos inclu�dos por el usuario, los cuales ser�n inclu�dos en variables para llamar a
	 * otro m�todo para proceder a incluir el nuevo proyecto.
	 */
	public static void nuevoProyecto() {
		String nombre = view.FrmNuevoProyecto.nuevoNombre.getText();
		String presupuesto = view.FrmNuevoProyecto.nuevoPresupuesto.getText();
		String fecha_inicio = view.FrmNuevoProyecto.nuevoFechaInicio.getText();
		String fecha_fin = view.FrmNuevoProyecto.nuevoFechaFin.getText();
		logic.LogicProyectos.nuevo(nombre, presupuesto, fecha_inicio, fecha_fin);
		inicio();
	}

	/**
	 * Obtendremos el �ndice del registro que pretendemos eliminar y con el que llamaremos a un m�todo para
	 * que elimine dicho registro.
	 */
	public static void borrar() {
		campoClave = logic.LogicProyectos.listadoID.get(view.FrmProyecto.lstProy.getSelectedIndex());
		
		logic.LogicProyectos.borrar(campoClave);
		inicio();
	}

	/**Tambi�n obtendremos el �ndice del registro que pretendemos editar llamando al constructor que nos
	 * mostrar� la ventana de editar donde se mostrar�n los campos actuales del mismo.
	 */
	public static void abrirEditar() {
		campoClave = logic.LogicProyectos.listadoID.get(view.FrmProyecto.lstProy.getSelectedIndex());
		
		new view.FrmEditarProyecto();
		
		view.FrmEditarProyecto.editarNombre.setText(logic.LogicProyectos.info("nombre", campoClave));
		view.FrmEditarProyecto.editarPresupuesto.setText(logic.LogicProyectos.info("presupuesto", campoClave));
		view.FrmEditarProyecto.editarFechaInicio.setText(logic.LogicProyectos.info("fecha_inicio", campoClave));
		view.FrmEditarProyecto.editarFechaFin.setText(logic.LogicProyectos.info("fecha_fin", campoClave));
	}
	
	/**
	 * Tambi�n con el �ndice del registro a editar, pasaremos a variales los campos ya editados y llamaremos
	 * a otro m�todo al que se las pasaremos para su edici�n.
	 */
	public static void editar() {	
		campoClave = logic.LogicProyectos.listadoID.get(view.FrmProyecto.lstProy.getSelectedIndex());
		
		String nombre = view.FrmEditarProyecto.editarNombre.getText();
		String presupuesto = view.FrmEditarProyecto.editarPresupuesto.getText();
		String fecha_inicio = view.FrmEditarProyecto.editarFechaInicio.getText();
		String fecha_fin = view.FrmEditarProyecto.editarFechaFin.getText();
		
		logic.LogicProyectos.editar(nombre, presupuesto, fecha_inicio, fecha_fin, campoClave);
		inicio();
	}

	/**
	 * Se har� referencia al constructor de la ventana de informaci�n del proyecto donde seguidamente y,
	 * mediante otro m�todo, se completar� con los campos almacenados.
	 */
	public static void abrirInfo() {
		new view.FrmInfoProyecto();
		infoProyecto();
	}

	/**Gracias al �ndice del registro del que queremos obtener informaci�n llamaremos a un m�todo para
	 * obtener cada uno de los campos almacenados que queremos mostrar.
	 */
	private static void infoProyecto() {
		campoClave = logic.LogicProyectos.listadoID.get(view.FrmProyecto.lstProy.getSelectedIndex());
		
		view.FrmInfoProyecto.infoIDProyecto.setText(logic.LogicProyectos.info("id_proyecto", campoClave));
		view.FrmInfoProyecto.infoNombre.setText(logic.LogicProyectos.info("nombre", campoClave));
		view.FrmInfoProyecto.infoPresupuesto.setText(logic.LogicProyectos.info("presupuesto", campoClave));
		view.FrmInfoProyecto.infoFechaInicio.setText(logic.LogicProyectos.info("fecha_inicio", campoClave));
		view.FrmInfoProyecto.infoFechaFin.setText(logic.LogicProyectos.info("fecha_fin", campoClave));
	}
	
}