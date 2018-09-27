package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmInfoProyecto extends Frame {

	private static final long serialVersionUID = 1L;
	
	public static Label infoIDProyecto = new Label();
	public static Label infoNombre = new Label();
	public static Label infoPresupuesto = new Label();
	public static Label infoFechaInicio = new Label();
	public static Label infoFechaFin = new Label();

	public FrmInfoProyecto() {
		setTitle("Info Proyecto");
		setResizable(false);
		setLayout(null);
		
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 280) / 2, (tamañoPantalla.height - 250) / 2, 280, 250);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				controller.CtrlProyecto.inicio();
			}
		});
		
		Label iDProyecto = new Label("ID Proyecto:");
		iDProyecto.setBounds(40,40,80,20);
		
		//Label infoIDProyecto = new Label();
		infoIDProyecto.setBounds(150,40,80,20);
		
		Label nombre = new Label("Nombre:");
		nombre.setBounds(40,80,80,20);
		
		//Label infoNombre = new Label();
		infoNombre.setBounds(150,80,80,20);
		
		Label presupuesto = new Label("Presupuesto:");
		presupuesto.setBounds(40,120,80,20);
		
		//Label infoPresupuesto = new Label();
		infoPresupuesto.setBounds(150,120,80,20);
		
		Label fechaInicio = new Label("Fecha Inicio:");
		fechaInicio.setBounds(40,160,80,20);
		
		//Label infoFechaInicio = new Label();
		infoFechaInicio.setBounds(150,160,80,20);
		
		Label fechaFin = new Label("Fecha Fin:");
		fechaFin.setBounds(40,200,80,20);
		
		//Label infoFechaFin = new Label();
		infoFechaFin.setBounds(150,200,80,20);
		
		add(iDProyecto);
		add(infoIDProyecto);
		add(nombre);
		add(infoNombre);
		add(presupuesto);
		add(infoPresupuesto);
		add(fechaInicio);
		add(infoFechaInicio);
		add(fechaFin);
		add(infoFechaFin);
		
		setVisible(true);
	}
	
}
