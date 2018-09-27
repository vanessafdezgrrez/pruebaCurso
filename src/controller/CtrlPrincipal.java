package controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

import view.FrmConexion;

/**
 * Para gestionar la funcionalidad de la pantalla principal de la aplicaci�n.
 */
public class CtrlPrincipal {

	public static HelpSet helpset = null;
	//public static HelpBroker hb = helpset.createHelpBroker();
	
	/**
	 * Llamaremos al constructor de la clase FrmPrincipal para que nos muestre la ventana principal de la
	 * aplicaci�n.
	 */
	public static void abrirVentana() {
		new view.FrmPrincipal();
	}

	/**
	 * Se nos cierra completamente la aplicaci�n.
	 */
	public static void salir() {
		System.exit(0);
	}
	
	/**
	 * Llamaremos al controlador de la ventana de proyectos para que nos la muestre.
	 */
	public static void abrirProyectos() {
		controller.CtrlProyecto.inicio();
	}

	/**
	 * Llamaremos al controlador de la ventana de trabajadores para que nos la muestre.
	 */
	public static void abrirTrabajadores() {
		controller.CtrlTrabajador.inicio();	
	}

	/**
	 * Llamaremos al controlador de la ventana de equipos para que nos la muestre.
	 */
	public static void abrirEquipos() {
		controller.CtrlEquipo.inicio();		
	}

	/**
	 * Llamaremos al constructor de la clase FrmConexion para que nos muestre la ventana de la conexi�n.
	 */
	public static void conectar() {
		new FrmConexion();
	}

	/**
	 * Modificaremos el estado del men� cuando la prueba de conexi�n haya sido correcta a "conectado".
	 * @param conectado Texto que mostraremos en el men�
	 */
	public static void estadoConectado(String conectado) {
		view.FrmPrincipal.conectar.setLabel(conectado);
	}

	public void crearAyuda() {
		File fichero = new File("javahelp/help_set.hs");
		URL hsURL = null;
		try {
			hsURL = fichero.toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			helpset = new HelpSet(getClass().getClassLoader(), hsURL);
		} catch (HelpSetException e) {
			e.printStackTrace();
		}
	}
	
}
