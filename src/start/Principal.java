package start;

/**
 * Para arrancar la aplicación.
 */
public class Principal {

	/**
	 * Crearemos un objeto que instancie a la clase con el que llamaremos a un método propio que arranque la
	 * aplicación.
	 * @param args
	 */
	public static void main(String[] args) {
		Principal p = new Principal();
		p.abrirAplicacion();
	}

	/**
	 * Nos dirigirá a otro método del controlador para abrir la ventana principal de l aplicación.
	 */
	private void abrirAplicacion() {
		controller.CtrlPrincipal.abrirVentana();
	}
	
}
