package view;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FrmEquipo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Choice lstProy = new Choice();
	public static JTable table;
	
	public FrmEquipo() {
		setTitle("Equipos");
		setResizable(false);
		setLayout(null);

		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width - 420) / 2, (tamañoPantalla.height - 300) / 2, 420, 300);
		
		Label lblListaProyectos = new Label("Proyectos:");
		lblListaProyectos.setBounds(30, 30, 80, 20);
		
		//Choice lstProy = new Choice();
		lstProy.setBounds(30, 50, 220, 200);
		lstProy.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged (ItemEvent arg0) {
				controller.CtrlEquipo.completarTabla();
			}
		});
		
		Label lblEquipos = new Label("Equipos:");
		lblEquipos.setBounds(30, 100, 80, 20);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 130, 350, 100);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modelo = new DefaultTableModel();
	
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("CARGO");
		
		table.setModel(modelo);
		
		Button btnAnadir = new Button("Añadir");
		btnAnadir.setBounds(40, 240, 50, 20);
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlEquipo.anadir();
				setVisible(false);
			}
		});
		
		Button btnEditar = new Button("Editar");
		btnEditar.setBounds(175, 240, 50, 20);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlEquipo.editar();
				setVisible(false);
			}
		});
		
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setBounds(310, 240, 50, 20);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlEquipo.eliminar();
				setVisible(false);
			}
		});
		
		add(lblListaProyectos);
		add(lstProy);
		add(lblEquipos);
		add(btnAnadir);
		add(btnEditar);
		add(btnEliminar);
		
		setVisible(true);
	}
	
}
