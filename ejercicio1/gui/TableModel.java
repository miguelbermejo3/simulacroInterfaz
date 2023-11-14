package examen.ejercicio1.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.ejercicio1.modelo.Coche;

public class TableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private List<Coche> coches;
	private List<String> columnas;
	private static final long serialVersionUID = 1L;

	public TableModel() {
		coches = new ArrayList<>();
		columnas = new ArrayList<>();
		columnas.add("MARCA");
		columnas.add("MODELO");
		columnas.add("MATRÍCULA");
		columnas.add("AÑO");
		columnas.add("DISPONIBLE");
	}

	@Override
	public int getRowCount() {

		return coches.size();
	}

	@Override
	public int getColumnCount() {

		return columnas.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnas.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche coche = coches.get(rowIndex);
		String nombreColumna = columnas.get(columnIndex);
		if (nombreColumna.equals("MARCA")) {
			return coche.getMarca();
		}
		if (nombreColumna.equals("MODELO")) {
			return coche.getModelo();
		}
		if (nombreColumna.equals("MATRÍCULA")) {
			return coche.getMatricula();
		}
		if (nombreColumna.equals("AÑO")) {
			return coche.getAño();
		}
		if (nombreColumna.equals("DISPONIBLE")) {

			if (coche.getDisponible()) {
				return "SI";
			}

			return "NO";

		}

		return "ERROR";
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

}
