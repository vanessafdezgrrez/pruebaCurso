package start;

/**
 * Para arrancar la aplicaci�n.
 */
public class Principal {

	/**
	 * Crearemos un objeto que instancie a la clase con el que llamaremos a un m�todo propio que arranque la
	 * aplicaci�n.
	 * @param args
	 */
	public static void main(String[] args) {
		Principal p = new Principal();
		p.abrirAplicacion();
	}

	/**
	 * Nos dirigir� a otro m�todo del controlador para abrir la ventana principal de l aplicaci�n.
	 */
	private void abrirAplicacion() {
		controller.CtrlPrincipal.abrirVentana();
	}
	
}
