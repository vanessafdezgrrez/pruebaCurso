package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

public class LogicProyectos {

	public static List<String> listadoID;
	
	public static List<String> getNombresProyecto() {
		listadoID = new ArrayList<String>();
		List<String> listado = new ArrayList<String>();
		try {
			CachedRowSet r = dbm.SQLServer.consultaSQL("SELECT nombre FROM FBProyectos");
			while(r.next()) {
				listado.add(r.getString(1));
			}
			CachedRowSet rID = dbm.SQLServer.consultaSQL("SELECT id_proyecto FROM FBProyectos");
			while(rID.next()) {
			listadoID.add(rID.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listado;
	}
	
	public static String info(String columna, String campoClave) {
		String dato = "";
		CachedRowSet r;
		try {
			r = dbm.SQLServer.consultaSQL("SELECT " + columna + " FROM FBProyectos WHERE id_proyecto = '" + campoClave + "'");
			while(r.next()) {
			dato = r.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dato;
	}

	public static void nuevo(String nombre, String presupuesto, String fecha_inicio, String fecha_fin) {
		try {
			dbm.SQLServer.consultaDML("INSERT INTO FBProyectos (nombre,presupuesto,fecha_inicio,fecha_fin) VALUES ('" + nombre + "','" + presupuesto + "','" + fecha_inicio + "','" + fecha_fin + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void borrar(String campoClave) {
		try {
			dbm.SQLServer.consultaDML("DELETE FROM FBProyectos WHERE id_proyecto = '" + campoClave + "'"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void editar(String nombre, String presupuesto, String fecha_inicio, String fecha_fin, String campoClave) {
		try {
			dbm.SQLServer.consultaDML("UPDATE FBProyectos SET nombre = '" + nombre + "' WHERE id_proyecto = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBProyectos SET presupuesto = '" + presupuesto + "' WHERE id_proyecto = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBProyectos SET fecha_inicio = '" + fecha_inicio + "' WHERE id_proyecto = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBProyectos SET fecha_fin = '" + fecha_fin + "' WHERE id_proyecto = '" + campoClave + "'"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}