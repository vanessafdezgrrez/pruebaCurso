package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmInfoTrabajador extends Frame {

	private static final long serialVersionUID = 1L;

	public static Label infoIDTrabajador = new Label();
	public static Label infoDNI = new Label();
	public static Label infoNombre = new Label();
	public static Label infoApellidos = new Label();
	public static Label infoGenero = new Label();

	public FrmInfoTrabajador() {
		setTitle("Info Trabajador");
		setResizable(false);
		setLayout(null);
		
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 280) / 2, (tamañoPantalla.height - 250) / 2, 280, 250);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				controller.CtrlTrabajador.inicio();
			}
		});
		
		Label iDTrabajador = new Label("ID Trabajador:");
		iDTrabajador.setBounds(40,40,80,20);
		
		//Label infoIDTrabajador = new Label();
		infoIDTrabajador.setBounds(150,40,80,20);
		
		Label dni = new Label("DNI:");
		dni.setBounds(40,80,80,20);
		
		//Label infoDNI = new Label();
		infoDNI.setBounds(150,80,80,20);
		
		Label nombre = new Label("Nombre:");
		nombre.setBounds(40,120,80,20);
		
		//Label infoNombre = new Label();
		infoNombre.setBounds(150,120,80,20);
		
		Label apellidos = new Label("Apellidos:");
		apellidos.setBounds(40,160,80,20);
		
		//Label infoApellidos = new Label();
		infoApellidos.setBounds(150,160,80,20);
		
		Label genero = new Label("Género:");
		genero.setBounds(40,200,80,20);
		
		//Label infoGenero = new Label();
		infoGenero.setBounds(150,200,80,20);
		
		add(iDTrabajador);
		add(infoIDTrabajador);
		add(dni);
		add(infoDNI);
		add(nombre);
		add(infoNombre);
		add(apellidos);
		add(infoApellidos);
		add(genero);
		add(infoGenero);
		
		setVisible(true);
	}
	
}
