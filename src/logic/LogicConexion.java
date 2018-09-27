package logic;

public class LogicConexion {

	static String direccionIP;
	static String puerto;
	static String baseDeDatos;
	static String usuario;
	static String contrasena;
	
	public static boolean conectar(String direccionIP, String puerto, String baseDeDatos, String usuario, String contrasena) {
		dbm.SQLServer.crearCadenaConexion(direccionIP, puerto, baseDeDatos, usuario, contrasena);
		return dbm.SQLServer.testConexion();
	}
	
}
