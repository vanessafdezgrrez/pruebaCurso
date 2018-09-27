package logic;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public class LogicEquipo {

	public static CachedRowSet consultaEquipo(String campoClave) {
		CachedRowSet resultado = null;
		try {
			resultado = dbm.SQLServer.consultaSQL(		"SELECT 	T.NOMBRE, T.APELLIDOS, C.CARGO "
																+ 	"FROM 		 FBTrabajador AS T "
																+ 				"INNER JOIN "
																+				"FBEquipo AS E "
																+				"ON "
																+				"T.ID_TRABAJADOR = E.ID_TRABAJADOR "
																+				"INNER JOIN "
																+				"FBProyectos AS P "
																+				"ON "
																+				"P.ID_PROYECTO = E.ID_TRABAJADOR "
																+				"INNER JOIN "
																+				"FBCargo AS C "
																+				"ON "
																+				"C.ID_CARGO = E.ID_CARGO "
																+	"WHERE		ID_PROYECTO = '" + campoClave + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public static void eliminar() {
		// TODO Auto-generated method stub
	}
	
}
