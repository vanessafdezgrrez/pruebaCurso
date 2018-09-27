package view;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmEditarTrabajador extends Frame {

	private static final long serialVersionUID = 1L;

	public static TextField editarDNI = new TextField();
	public static TextField editarNombre = new TextField();
	public static TextField editarApellidos = new TextField();
	public static TextField editarGenero = new TextField();
	
	public FrmEditarTrabajador() {
		setTitle("Editar Trabajador");
		setResizable(false);
		setLayout(null);
		
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 280) / 2, (tamañoPantalla.height - 300) / 2, 280, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				controller.CtrlTrabajador.inicio();
			}
		});
		
		Label dni = new Label("DNI:");
		dni.setBounds(40,80,80,20);
		
		//TextField editarDNI = new TextField();
		editarDNI.setBounds(150,80,80,20);
		
		Label nombre = new Label("Nombre:");
		nombre.setBounds(40,120,80,20);
		
		//TextField editarNombre = new TextField();
		editarNombre.setBounds(150,120,80,20);
		
		Label apellidos = new Label("Apellidos:");
		apellidos.setBounds(40,160,80,20);
		
		//TextField editarApellidos = new TextField();
		editarApellidos.setBounds(150,160,80,20);
		
		Label genero = new Label("Género:");
		genero.setBounds(40,200,80,20);
		
		//TextField editarGenero = new TextField();
		editarGenero.setBounds(150,200,80,20);
		
		Button aceptar = new Button("Aceptar");
		aceptar.setBounds(100,260,80,20);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajador.editar();
				dispose();
			}
		});
		
		add(dni);
		add(editarDNI);
		add(nombre);
		add(editarNombre);
		add(apellidos);
		add(editarApellidos);
		add(genero);
		add(editarGenero);
		add(aceptar);
		
		setVisible(true);
	}	
	
}
