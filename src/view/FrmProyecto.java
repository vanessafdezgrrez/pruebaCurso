package view;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmProyecto extends Frame {

	private static final long serialVersionUID = 1L;

	public static List lstProy;
	Button btnNuevo, btnBorrar, btnEditar, btnInfo;
	Label infoNombreProyecto = new Label();
	Label infoPresupuestoProyecto = new Label();
	Label infoFechaInicioProyecto = new Label();
	Label infoFechaFinProyecto = new Label();;

	public FrmProyecto() {
		setTitle("Proyectos");
		setResizable(false);
		setLayout(null);

		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 280) / 2, (tamañoPantalla.height - 300) / 2, 280, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});

		lstProy = new List();
		lstProy.setBounds(30, 30, 220, 200);

		btnNuevo = new Button("Nuevo");
		btnNuevo.setBounds(40, 250, 40, 20);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyecto.abrirNuevo();
				setVisible(false);
			}
		});

		btnBorrar = new Button("Borrar");
		btnBorrar.setBounds(90, 250, 40, 20);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyecto.borrar();
				setVisible(false);
			}
		});

		btnEditar = new Button("Editar");
		btnEditar.setBounds(140, 250, 40, 20);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyecto.abrirEditar();
				setVisible(false);
			}
		});

		btnInfo = new Button("info");
		btnInfo.setBounds(190, 250, 40, 20);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlProyecto.abrirInfo();
				setVisible(false);
			}
		});

		add(lstProy);
		add(btnNuevo);
		add(btnBorrar);
		add(btnEditar);
		add(btnInfo);
		
		setVisible(true);
	}
	
}