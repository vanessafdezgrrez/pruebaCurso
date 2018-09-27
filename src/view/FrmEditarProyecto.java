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

public class FrmEditarProyecto extends Frame {

	private static final long serialVersionUID = 1L;

	public static TextField editarNombre = new TextField();
	public static TextField editarPresupuesto = new TextField();
	public static TextField editarFechaInicio = new TextField();
	public static TextField editarFechaFin = new TextField();
	
	public FrmEditarProyecto() {
		setTitle("Editar Proyecto");
		setResizable(false);
		setLayout(null);
		
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 280) / 2, (tamañoPantalla.height - 300) / 2, 280, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				controller.CtrlProyecto.inicio();
			}
		});
		
		Label nombre = new Label("Nombre:");
		nombre.setBounds(40,80,80,20);
		
		//TextField editarNombre = new TextField();
		editarNombre.setBounds(150,80,80,20);
		
		Label presupuesto = new Label("Presupuesto:");
		presupuesto.setBounds(40,120,80,20);
		
		//TextField editarPresupuesto = new TextField();
		editarPresupuesto.setBounds(150,120,80,20);
		
		Label fechaInicio = new Label("Fecha Inicio:");
		fechaInicio.setBounds(40,160,80,20);
		
		//TextField editarFechaInicio = new TextField();
		editarFechaInicio.setBounds(150,160,80,20);
		
		Label fechaFin = new Label("Fecha Fin:");
		fechaFin.setBounds(40,200,80,20);
		
		//TextField editarFechaFin = new TextField();
		editarFechaFin.setBounds(150,200,80,20);
		
		Button aceptar = new Button("Aceptar");
		aceptar.setBounds(100,260,80,20);
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyecto.editar();
				dispose();
			}
		});
		
		add(nombre);
		add(editarNombre);
		add(presupuesto);
		add(editarPresupuesto);
		add(fechaInicio);
		add(editarFechaInicio);
		add(fechaFin);
		add(editarFechaFin);
		add(aceptar);
		
		setVisible(true);
	}
	
}
