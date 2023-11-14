package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PantallaAlta extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNuevaMarca;

	public PantallaAlta(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblNuevaMarca = new JLabel("Nueva Marca: ");
		lblNuevaMarca.setBounds(72, 105, 70, 14);
		add(lblNuevaMarca);

		textFieldNuevaMarca = new JTextField();
		textFieldNuevaMarca.setBounds(149, 102, 86, 20);
		add(textFieldNuevaMarca);
		textFieldNuevaMarca.setColumns(10);

		JLabel lblMarcas = new JLabel("Marcas: ");
		lblMarcas.setBounds(90, 162, 46, 14);
		add(lblMarcas);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(149, 158, 88, 22);
		List<String> marcas = appController.consultarMarcas();
		for (String string : marcas) {
			comboBox.addItem(string);
		}

		add(comboBox);

		JButton btnAnhadir = new JButton("AÑADIR");
		btnAnhadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNuevaMarca.getText().isBlank()) {
					comboBox.addItem(appController.anhadirMarca(textFieldNuevaMarca.getText()));
				}

			}
		});
		btnAnhadir.setBounds(300, 101, 89, 23);
		add(btnAnhadir);

	}
}
