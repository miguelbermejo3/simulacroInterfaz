package examen.ejercicio1.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import examen.ejercicio1.modelo.Coche;
import examen.ejercicio1.services.ExamenService;

public class App {

	private JFrame frame;
	private JMenuBar menuBar;

	private PantallaBienvenida pantallaBienvenida;
	private PantallaInicio pantallaInicio;
	private PantallaAlta pantallaAlta;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmAlta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		pantallaBienvenida = new PantallaBienvenida(this);
		pantallaInicio = new PantallaInicio(this);
		pantallaAlta = new PantallaAlta(this);
		irAPantallaBienvenida();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 568, 22);
		frame.setJMenuBar(menuBar);

		JMenu mnMenu1 = new JMenu("MENÚ");
		menuBar.add(mnMenu1);

		 mntmAlta = new JMenuItem("ALTA");
		ActionListener listenerAlta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				irAPantallaAlta();

			}
		};
		mntmAlta.addActionListener(listenerAlta);
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mnMenu1.add(mntmAlta);

		JMenuItem mntmCS = new JMenuItem("CERRAR SESIÓN");
		ActionListener listenerCerrarSesion = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				irAPantallaBienvenida();

			}
		};
		mntmCS.addActionListener(listenerCerrarSesion);
		
		 mntmConsultar = new JMenuItem("CONSULTAR");
		 mntmConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		 ActionListener listenerConsulta=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				irAPantallaInicio();
				
			}
		};
		mntmConsultar.addActionListener(listenerConsulta);
		mnMenu1.add(mntmConsultar);
		mntmCS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnMenu1.add(mntmCS);

		JMenuItem mntmExit = new JMenuItem("SALIR");
		ActionListener listenerSalir1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		};
		mntmExit.addActionListener(listenerSalir1);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mnMenu1.add(mntmExit);
	}

	public void irAPantallaBienvenida() {
		frame.setContentPane(pantallaBienvenida);
		menuBar.setVisible(false);
		frame.revalidate();
	}

	public void irAPantallaInicio() {

		frame.setContentPane(pantallaInicio);
		menuBar.setVisible(true);
		mntmConsultar.setVisible(false);
		 mntmAlta.setVisible(true);
		frame.revalidate();
	}

	public void irAPantallaAlta() {

		frame.setContentPane(pantallaAlta);
		menuBar.setVisible(true);
		mntmConsultar.setVisible(true);
		 mntmAlta.setVisible(false);
		frame.revalidate();
	}

	public List<Coche> consultarCoches() {
		ExamenService es = new ExamenService();
		List<Coche> coches = es.consultarCoches();

		return coches;

	}

	public List<Coche> consultarCochePorDisponibilidad(Boolean disponible) {
		ExamenService es = new ExamenService();
		List<Coche> coches = es.consultarCochesDisponibles(disponible);
		return coches;
	}
	
	public List<String> consultarMarcas(){
		ExamenService es= new ExamenService();
		List<String>marcas=es.consultarMarcas();
		
		
		return marcas;
	}
	public String anhadirMarca(String marca) {
		ExamenService es= new ExamenService();
		es.añadirMarca(marca);
		return marca;
	}
	public void salirApp() {
		int i = JOptionPane.showConfirmDialog(frame,"¿seguro que desea salir?","SALIR",JOptionPane.YES_NO_OPTION.JOptionPane.QUESTION_MESSAGE);
	}
	
	
	
	
	
	
	
	
}
