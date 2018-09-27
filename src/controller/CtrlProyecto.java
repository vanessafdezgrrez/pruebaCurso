package controller;

import java.util.List;

/**
 * Para gestionar la funcionalidad de la ventana de proyectos principalmente.
 */
public class CtrlProyecto {
	
	public static List<String> lst;
	private static String campoClave;

	/**
	 * Llamaremos al constructor de la clase que nos mostrará la ventana de proyectos.
	 * También, obtendremos una lista con los nombres de los proyectos gracias a otro método de la capa lógica
	 * con la que rellenaremos la lista de proyectos que aparecerá en nuestra ventana.
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
	 * Obtendremos los datos incluídos por el usuario, los cuales serán incluídos en variables para llamar a
	 * otro método para proceder a incluir el nuevo proyecto.
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
	 * Obtendremos el índice del registro que pretendemos eliminar y con el que llamaremos a un método para
	 * que elimine dicho registro.
	 */
	public static void borrar() {
		campoClave = logic.LogicProyectos.listadoID.get(view.FrmProyecto.lstProy.getSelectedIndex());
		
		logic.LogicProyectos.borrar(campoClave);
		inicio();
	}

	/**También obtendremos el índice del registro que pretendemos editar llamando al constructor que nos
	 * mostrará la ventana de editar donde se mostrarán los campos actuales del mismo.
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
	 * También con el índice del registro a editar, pasaremos a variales los campos ya editados y llamaremos
	 * a otro método al que se las pasaremos para su edición.
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
	 * Se hará referencia al constructor de la ventana de información del proyecto donde seguidamente y,
	 * mediante otro método, se completará con los campos almacenados.
	 */
	public static void abrirInfo() {
		new view.FrmInfoProyecto();
		infoProyecto();
	}

	/**Gracias al índice del registro del que queremos obtener información llamaremos a un método para
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