package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.CtrlPrincipal;

public class FrmPrincipal extends Frame {

	static TextField nombreProyecto = new TextField();
	static TextField presupuestoProyecto = new TextField();
	static TextField fechaInicioProyecto = new TextField();
	static TextField fechaFinProyecto = new TextField();
	static Label infoNombreProyecto = new Label();
	static Label infoPresupuestoProyecto = new Label();
	static Label infoFechaInicioProyecto = new Label();
	static Label infoFechaFinProyecto = new Label();
	static TextField editarNombreProyecto = new TextField();
	static TextField editarPresupuestoProyecto = new TextField();
	static TextField editarFechaInicioProyecto = new TextField();
	static TextField editarFechaFinProyecto = new TextField();
	
	public static MenuItem conectar = new MenuItem("PROBAR CONEXI�N");
	public static MenuItem ayuda = new MenuItem("Ayuda");
	
	private static final long serialVersionUID = 1L;

	public FrmPrincipal() {
		crearVentana();
		setVisible(true);
	}

	private void crearVentana() {
		setTitle("EMPRESA");
		int anchoVentana = 300;
		int altoVentana = 330;
		Dimension tama�oPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tama�oPantalla.width-anchoVentana)/2,(tama�oPantalla.height-altoVentana)/2,anchoVentana,altoVentana);
		
		MenuBar barraMenu = new MenuBar();
		
		Menu menu = new Menu("MEN�");
		MenuItem proyectos = new MenuItem("Proyectos");
		proyectos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.CtrlPrincipal.abrirProyectos();
			}
		});
		MenuItem trabajadores = new MenuItem("Trabajadores");
		trabajadores.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.CtrlPrincipal.abrirTrabajadores();
			}
		});
		
		//MenuItem conectar = new MenuItem("PROBAR CONEXI�N");
		conectar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.CtrlPrincipal.conectar();
			}
		});
		
		//MenuItem ayuda = new MenuItem("Ayuda");
		ayuda.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				//controller.CtrlPrincipal.hb.enableHelpOnButton(ayuda, "aplicacion", controller.CtrlPrincipal.helpset);
			}
		});
		
		MenuItem salir = new MenuItem("Salir");
		salir.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.CtrlConexion.salir();
			}
		});
		
		Menu gestion = new Menu("GESTI�N");
		MenuItem equipos = new MenuItem("EQUIPOS");
		equipos.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.CtrlPrincipal.abrirEquipos();
			}
		});
		
		menu.add(proyectos);
		menu.add(trabajadores);
		menu.addSeparator();
		menu.add(conectar);
		menu.addSeparator();
		menu.add(ayuda);
		menu.addSeparator();
		menu.add(salir);
		
		gestion.add(equipos);
		
		barraMenu.add(menu);
		barraMenu.add(gestion);
		
		setMenuBar(barraMenu);			
		
		setResizable(false);
		setLayout(null);
		
		CtrlPrincipal c = new CtrlPrincipal();
		c.crearAyuda();
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.CtrlPrincipal.salir();
			}
		});
	}
	
}