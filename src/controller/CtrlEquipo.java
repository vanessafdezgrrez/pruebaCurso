package controller;

import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

/**
 *  Para gestionar la funcionalidad de la ventana de equipos principalmente.
 */
public class CtrlEquipo {
	
	/**
	 * Para llamar al constructor de la ventana de equipos para que nos la muestre con el listado de proyectos
	 * almacenados.
	 */
	public static void inicio() {
		new view.FrmEquipo();
		List<String> lst = logic.LogicProyectos.getNombresProyecto();
		view.FrmEquipo.lstProy.removeAll();
		for(String str : lst) {
			view.FrmEquipo.lstProy.add(str);
		}
	}
	
	/**
	 * Se completará la tabla con la lista de trabajadores y cargos de los mismos para un determinado proyecto,
	 * el cual lo sabremos gracias a un índice que lo identifique.
	 */
	public static void completarTabla() {
		String campoClave = logic.LogicProyectos.listadoID.get(view.FrmEquipo.lstProy.getSelectedIndex());
		
		CachedRowSet resultado = logic.LogicEquipo.consultaEquipo(campoClave);
		DefaultTableModel m = null;
		try {
			m = utils.Gui.generarTabla(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		view.FrmEquipo.table.setModel(m);
	}

	/**
	 * Llamaremos al constructor para que se nos muestre una ventana con la lista de los trabajadores de la
	 * que debemos seleccionar uno para añadirlo al equipo sobre el que estemos trabajando.
	 */
	public static void anadir() {
		new view.FrmAnadir();
		List<String> lst = logic.LogicTrabajador.getNombresTrabajador();
		view.FrmAnadir.listaTrabajadores.removeAll();
		for(String str : lst) {
			view.FrmAnadir.listaTrabajadores.add(str);
		}
	}

	/**
	 * Llamaremos al constructor para que se nos muestre la ventana con los diferentes cargos para así
	 * asignárselo al trabajador seleccionado en el método anterior.
	 */
	public static void editar() {
		new view.FrmEditar();
	}

	/**
	 * Llamaremos a un método para la eliminación del trabajador y cargo de un determinado proyecto, y
	 * mostraremos de nuevo la ventana de equipos actualizada refiriéndolos al método de inicio.
	 */
	public static void eliminar() {
		logic.LogicEquipo.eliminar();
		inicio();
	}
	
}
