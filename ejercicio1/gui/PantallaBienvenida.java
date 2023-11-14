package examen.ejercicio1.gui;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaBienvenida extends View {

	
	private static final long serialVersionUID = 1L;

	public PantallaBienvenida(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblTitulo = new JLabel("Bienvenido a Car Shop");
		lblTitulo.setForeground(new Color(128, 0, 255));
		lblTitulo.setFont(new Font("Freestyle Script", Font.PLAIN, 80));
		lblTitulo.setBackground(new Color(64, 0, 128));
		lblTitulo.setBounds(52, 72, 509, 77);
		add(lblTitulo);

		JLabel lblCondiciones = new JLabel("Acepta los términos y condiciones");
		lblCondiciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCondiciones.setBounds(141, 185, 216, 40);
		add(lblCondiciones);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setEnabled(false);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				appController.irAPantallaInicio();

			}
		});
		
		JCheckBox chckbxCondiciones = new JCheckBox("");
		chckbxCondiciones.setBounds(377, 196, 27, 23);
		chckbxCondiciones.setSelected(false);
		ActionListener al=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxCondiciones.isSelected()) {
					btnEntrar.setEnabled(true);
				}
				else {
					btnEntrar.setEnabled(false);
				}
				
			}
		};
		chckbxCondiciones.addActionListener(al);
		add(chckbxCondiciones);

		
		

		

		btnEntrar.setBounds(220, 270, 126, 40);
		add(btnEntrar);

	}
}
