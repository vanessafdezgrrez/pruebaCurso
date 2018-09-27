package controller;

/**
 * Para gestionar la funcionalidad de la pantalla de conexión.
 */
public class CtrlConexion {
	
	/**
	 * Llama al constructor de la clase FrmConexion mediante el cual abriremos la ventana para solicitar los
	 * datos para establecer la conexión.
	 */
	public static void abrirVentana() {
		new view.FrmConexion();
	}
	
	/**
	 * Mediante el cual se nos cierra la ventana de la conexión.
	 */
	public static void salir() {
		System.exit(0);
	}

	/**
	 * Obtendremos de los campos de la ventana de la conexión los datos necesarios para establecer la conexión
	 * de la aplicación.
	 * Dentro de dicho método llamaremos a otro en el que realizaremos un test de conexión con los datos
	 * obtenidos.
	 */
	public static void conexion() {
		String direccionIP = view.FrmConexion.txtDireccionIP.getText();
		String puerto = view.FrmConexion.txtPuerto.getText();
		String baseDeDatos = view.FrmConexion.txtBaseDeDatos.getText();
		String usuario = view.FrmConexion.txtUsuario.getText();
		String contrasena = view.FrmConexion.txtContrasena.getText();
		boolean resultadoTest = logic.LogicConexion.conectar(direccionIP, puerto, baseDeDatos, usuario, contrasena);
		
		if (resultadoTest) {
			view.FrmPrincipal.conectar.setLabel("CONECTADO");
			System.out.println("CONECTADO");
		} else {
			view.FrmPrincipal.conectar.setLabel("PROBAR CONEXIÓN");
			System.out.println("NO CONECTADO");
		}
	}
	
}