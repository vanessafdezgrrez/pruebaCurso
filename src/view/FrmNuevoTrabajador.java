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

public class FrmNuevoTrabajador extends Frame {

	private static final long serialVersionUID = 1L;

	public static TextField nuevoDNI = new TextField();
	public static TextField nuevoNombre = new TextField();
	public static TextField nuevoApellidos = new TextField();
	public static TextField nuevoGenero = new TextField();
	
	public FrmNuevoTrabajador() {
		setTitle("Nuevo Trabajador");
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
		
		//TextField nuevoDNI = new TextField();
		nuevoDNI.setBounds(150,80,80,20);
		
		Label nombre = new Label("Nombre:");
		nombre.setBounds(40,120,80,20);
		
		//TextField nuevoNombre = new TextField();
		nuevoNombre.setBounds(150,120,80,20);
		
		Label apellidos = new Label("Apellidos:");
		apellidos.setBounds(40,160,80,20);
		
		//TextField nuevoApellidos = new TextField();
		nuevoApellidos.setBounds(150,160,80,20);
		
		Label genero = new Label("Género:");
		genero.setBounds(40,200,80,20);
		
		//TextField nuevoGenero = new TextField();
		nuevoGenero.setBounds(150,200,80,20);
		
		Button aceptar = new Button("Aceptar");
		aceptar.setBounds(100,260,80,20);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajador.nuevoTrabajador();
				nuevoDNI.setText("");
				nuevoNombre.setText("");
				nuevoApellidos.setText("");
				nuevoGenero.setText("");
				dispose();
			}
		});
		
		add(dni);
		add(nuevoDNI);
		add(nombre);
		add(nuevoNombre);
		add(apellidos);
		add(nuevoApellidos);
		add(genero);
		add(nuevoGenero);
		add(aceptar);
		
		setVisible(true);
	}
	
}
