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
	 * Pas�ndole los diferentes par�metros necesarios, construiremos la cadena de conexi�n que posteriormente
	 * utilizaremos para crear la conexi�n con la base de datos.
	 * @param strIP Direcci�n IP de la Base de Datos
	 * @param strPort Puerto de acceso a la misma
	 * @param strDatabaseName Nombre de la Base de Datos
	 * @param strUserName Nombre de usuario
	 * @param strUserPassword Contrase�a de acceso del mismo
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
	 * Crearemos la cadena de conexi�n gracias a la cadena que le pasaremos.
	 * Nos devolver� un objeto Connection con la conexi�n.
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);
		
	}
	
	/**
	 * Para cerrar la conexi�n que le pasemos como par�metro.
	 * @param conn Conexi�n que pretendemos cerrar
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection conn)  throws SQLException {
		conn.close();
	}
	
	/**
	 * Para proceder a realizar una consulta determinada que le pasaremos como String, normalmente del tipo
	 * SELECT.
	 * Nos devolver� el resultado de la consulta en CachedRowSet para poder trabajar con �l sin conexi�n a la
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
	 * Haremos un test de conexi�n probando si la conexi�n es correcta o no. Para ello, llamaremos a otros
	 * m�todos que har�n y cerrar�n la conexi�n.
	 * Nos devolver� un valor booleano dependiente si todo ha ido bien o no.
	 * @return boolean Si la conexi�n ha ido correctamente devolver� un valor booleano true. Y, en caso contrario, false.
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
