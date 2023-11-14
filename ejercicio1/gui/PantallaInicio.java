package examen.ejercicio1.gui;

import examen.ejercicio1.modelo.Coche;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	public PantallaInicio(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Sólo Disponibles :");
		lblNewLabel.setBounds(53, 100, 93, 14);
		add(lblNewLabel);

		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(152, 96, 61, 23);
		add(rdbtnSi);

		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(224, 96, 65, 23);
		add(rdbtnNo);

		JRadioButton rdbtnTodos = new JRadioButton("Todos");
		rdbtnTodos.setBounds(291, 96, 61, 23);
		add(rdbtnTodos);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 136, 457, 153);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		TableModel modelo = new TableModel();
		table.setModel(modelo);

		ButtonGroup gb = new ButtonGroup();
		gb.add(rdbtnTodos);
		gb.add(rdbtnNo);
		gb.add(rdbtnSi);

		rdbtnTodos.setSelected(true);

		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnSi.isSelected()) {
					List<Coche> coches = appController.consultarCochePorDisponibilidad(true);
					modelo.setCoches(coches);

				} else if (rdbtnNo.isSelected()) {
					List<Coche> coches = appController.consultarCochePorDisponibilidad(false);
					modelo.setCoches(coches);

				} else {

					List<Coche> coches = appController.consultarCoches();
					modelo.setCoches(coches);

				}
				modelo.fireTableDataChanged();

			}
		});
		btnNewButton.setBounds(381, 96, 108, 23);
		add(btnNewButton);

	}
}
