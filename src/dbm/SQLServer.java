package dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
// hola
/**
 * Para acceder y trabajar con la base de datos SQLServer.
 */
public class SQLServer {
	
	public static String cadenaConexion;
	
	/**
	 * Pasándole los diferentes parámetros necesarios, construiremos la cadena de conexión que posteriormente
	 * utilizaremos para crear la conexión con la base de datos.
	 * @param strIP Dirección IP de la Base de Datos
	 * @param strPort Puerto de acceso a la misma
	 * @param strDatabaseName Nombre de la Base de Datos
	 * @param strUserName Nombre de usuario
	 * @param strUserPassword Contraseña de acceso del mismo
	 */
	public static void crearCadenaConexion( String strIP
										  , String strPort
										  , String strDatabaseName
										  , String strUserName
										  , String strUserPassword
										  ) {
		
		String cadena  = "jdbc:sqlserver:";
			   cadena += "//" + strIP;
			   cadena += ":" + strPort;
			   cadena += ";database=" + strDatabaseName;
			   cadena += ";user=" + strUserName;
			   cadena += ";password=" + strUserPassword;

		cadenaConexion = cadena;
	}
	
	/**
	 * Crearemos la cadena de conexión gracias a la cadena que le pasaremos.
	 * Nos devolverá un objeto Connection con la conexión.
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);
		
	}
	
	/**
	 * Para cerrar la conexión que le pasemos como parámetro.
	 * @param conn Conexión que pretendemos cerrar
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection conn)  throws SQLException {
		conn.close();
	}
	
	/**
	 * Para proceder a realizar una consulta determinada que le pasaremos como String, normalmente del tipo
	 * SELECT.
	 * Nos devolverá el resultado de la consulta en CachedRowSet para poder trabajar con él sin conexión a la
	 * base de datos.
	 * @param strSQL Consulta SQL que haremos a la base de datos.
	 * @return CachedRowSet con el que trabajaremos con el resultado obtenido de la consulta.
	 * @throws SQLException
	 */
	public static CachedRowSet consultaSQL(String strSQL) throws SQLException {
		Connection c = establecerConexion();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(strSQL);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowset = factory.createCachedRowSet();
		rowset.populate(r);
		cerrarConexion(c);
		
		return rowset;
	}
	
	/**
	 * Para proceder a realizar una sentencia DML que le pasaremos como String.
	 * @param strSQL Sentencia DML que haremos en la base de datos.
	 * @throws SQLException
	 */
	public static void consultaDML(String strSQL) throws SQLException {
		Connection c = establecerConexion();
		Statement s = c.createStatement();
		s.executeUpdate(strSQL);
		cerrarConexion(c);
	}
	
	/**
	 * Haremos un test de conexión probando si la conexión es correcta o no. Para ello, llamaremos a otros
	 * métodos que harán y cerrarán la conexión.
	 * Nos devolverá un valor booleano dependiente si todo ha ido bien o no.
	 * @return boolean Si la conexión ha ido correctamente devolverá un valor booleano true. Y, en caso contrario, false.
	 */
	public static boolean testConexion() {
		boolean estado = false;
		try {
			Connection c = establecerConexion();
			cerrarConexion(c);
			estado = true;
		} catch(Exception e) {
			estado = false;
		}
		return estado;
	}
	
}
