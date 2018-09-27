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

public class FrmConexion extends Frame {

	public static TextField txtDireccionIP = new TextField();
	public static TextField txtPuerto = new TextField();
	public static TextField txtBaseDeDatos = new TextField();
	public static TextField txtUsuario = new TextField();
	public static TextField txtContrasena = new TextField();
	
	private static final long serialVersionUID = 1L;
	
	public FrmConexion() {
		System.out.println("jdbc:sqlserver://192.168.1.230:1433;databaseName=BDCurso;user=cursocp;password=Avante-16");
		
		setTitle("Probar Conexión");
		int anchoVentana = 300;
		int altoVentana = 330;
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((tamañoPantalla.width-anchoVentana)/2,(tamañoPantalla.height-altoVentana)/2,anchoVentana,altoVentana);		
		
		Label lblDireccionIP = new Label();
		lblDireccionIP.setText("Dirección IP:");
		lblDireccionIP.setBounds(40,40,100,20);
		
		Label lblPuerto = new Label();
		lblPuerto.setText("Puerto:");
		lblPuerto.setBounds(40,80,100,20);
		
		Label lblBaseDeDatos = new Label();
		lblBaseDeDatos.setText("Base de Datos:");
		lblBaseDeDatos.setBounds(40,120,100,20);
		
		Label lblUsuario = new Label();
		lblUsuario.setText("Usuario:");
		lblUsuario.setBounds(40,160,100,20);
		
		Label lblContrasena = new Label();
		lblContrasena.setText("Contraseña:");
		lblContrasena.setBounds(40,200,100,20);
		
		//TextField txtDireccionIP = new TextField();
		txtDireccionIP.setBounds(150,40,110,20);
		
		//TextField txtPuerto = new TextField();
		txtPuerto.setBounds(150,80,110,20);
		
		//TextField txtBaseDeDatos = new TextField();
		txtBaseDeDatos.setBounds(150,120,110,20);
		
		//TextField txtUsuario = new TextField();
		txtUsuario.setBounds(150,160,110,20);
		
		//TextField txtContrasena = new TextField();
		txtContrasena.setBounds(150,200,110,20);
		
		Button btnEstablecerConexion = new Button();
		btnEstablecerConexion.setLabel("Extablecer Conexión");
		btnEstablecerConexion.setBounds(95,240,120,20);
		btnEstablecerConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlConexion.conexion();
				dispose();
			}
		});
		
		add(lblDireccionIP);
		add(lblPuerto);
		add(lblBaseDeDatos);
		add(lblUsuario);
		add(lblContrasena);
		add(txtDireccionIP);
		add(txtPuerto);
		add(txtBaseDeDatos);
		add(txtUsuario);
		add(txtContrasena);
		add(btnEstablecerConexion);
		
		setResizable(false);
		setLayout(null);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
}
