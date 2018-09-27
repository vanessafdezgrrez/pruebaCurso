package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;

public class LogicTrabajador {

	public static List<String> listadoID;
	
	public static List<String> getNombresTrabajador() {
		listadoID = new ArrayList<String>();
		List<String> listado = new ArrayList<String>();
		try {
			CachedRowSet r = dbm.SQLServer.consultaSQL("SELECT nombre FROM FBTrabajador");
			while(r.next()) {
				listado.add(r.getString(1));
			}
			CachedRowSet rID = dbm.SQLServer.consultaSQL("SELECT id_trabajador FROM FBTrabajador");
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
			r = dbm.SQLServer.consultaSQL("SELECT " + columna + " FROM FBTrabajador WHERE id_trabajador = '" + campoClave + "'");
			while(r.next()) {
			dato = r.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dato;
	}

	public static void nuevo(String dni, String nombre, String apellidos, String genero) {
		try {
			dbm.SQLServer.consultaDML("INSERT INTO FBTrabajador (dni,nombre,apellidos,genero) VALUES ('" + dni + "','" + nombre + "','" + apellidos + "','" + genero + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void borrar(String campoClave) {
		try {
			dbm.SQLServer.consultaDML("DELETE FROM FBTrabajador WHERE id_trabajador = '" + campoClave + "'"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void editar(String dni, String nombre, String apellidos, String genero, String campoClave) {
		try {
			dbm.SQLServer.consultaDML("UPDATE FBTrabajador SET dni = '" + dni + "' WHERE id_trabajador = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBTrabajador SET nombre = '" + nombre + "' WHERE id_trabajador = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBTrabajador SET apellidos = '" + apellidos + "' WHERE id_trabajador = '" + campoClave + "'"); 
			dbm.SQLServer.consultaDML("UPDATE FBTrabajador SET genero = '" + genero + "' WHERE id_trabajador = '" + campoClave + "'"); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
