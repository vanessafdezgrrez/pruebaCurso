package view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmAnadir extends Frame {

	private static final long serialVersionUID = 1L;

	public static Choice listaTrabajadores = new Choice();
	
	public FrmAnadir() {
		setTitle("Añadir Trabajador");
		int anchoVentana = 300;
		int altoVentana = 150;
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width-anchoVentana)/2,(tamañoPantalla.height-altoVentana)/2,anchoVentana,altoVentana);		

		Label lblTrabajador = new Label("Trabajadores:");
		lblTrabajador.setBounds(30,35,80,20);
		
		//Choice listaTrabajadores = new Choice();
		listaTrabajadores.setBounds(30,60,240,20);
		
		Button btnAceptar = new Button("Aceptar");
		btnAceptar.setBounds(125,100,50,20);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				controller.CtrlEquipo.inicio();
			}
		});
		
		add(lblTrabajador);
		add(listaTrabajadores);
		add(btnAceptar);
		
		setResizable(false);
		setLayout(null);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				controller.CtrlEquipo.inicio();
			}
		});
		
		setVisible(true);
	}
	
}
