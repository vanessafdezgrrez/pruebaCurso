package controller;

/**
 * Para gestionar la funcionalidad de la pantalla de conexi�n.
 */
public class CtrlConexion {
	
	/**
	 * Llama al constructor de la clase FrmConexion mediante el cual abriremos la ventana para solicitar los
	 * datos para establecer la conexi�n.
	 */
	public static void abrirVentana() {
		new view.FrmConexion();
	}
	
	/**
	 * Mediante el cual se nos cierra la ventana de la conexi�n.
	 */
	public static void salir() {
		System.exit(0);
	}

	/**
	 * Obtendremos de los campos de la ventana de la conexi�n los datos necesarios para establecer la conexi�n
	 * de la aplicaci�n.
	 * Dentro de dicho m�todo llamaremos a otro en el que realizaremos un test de conexi�n con los datos
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
			view.FrmPrincipal.conectar.setLabel("PROBAR CONEXI�N");
			System.out.println("NO CONECTADO");
		}
	}
	
}