package team3.view.doctor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import team3.Database;
import team3.controller.MedicineController;
import team3.model.Medicine;
import team3.model.Prescription;

public class MedicineInPrescriptionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private static Database database = Database.getInstance();
	private List<String> kolone = new ArrayList<String>();
	private boolean editable;
	private Prescription prescription;

	public MedicineInPrescriptionTableModel(boolean editable, Prescription p) {
		this.editable = editable;
		kolone.add("Šifra leka");
		kolone.add("Naziv leka");
		kolone.add("Kolièina");
		kolone.add("Cena");
		prescription = p;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 4 && editable;
	}

	@Override
	public int getRowCount() {
		return prescription.getMeds().size();
	}

	@Override
	public int getColumnCount() {
		return kolone.size();
	}

	@Override
	public String getColumnName(int column) {
		return kolone.get(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		case 3:
			return float.class;
		default:
			return null;
		}
	}

	@Override

	public Object getValueAt(int rowIndex, int columnIndex) {
		int i = 0;

		for (String id : prescription.getMeds().keySet()) {
			if (i == rowIndex) {
				Integer q=prescription.getMeds().get(id);
				Medicine med=MedicineController.getById(id);
				switch (columnIndex) {
				case 0:
					return med.getId();
				case 1:
					return med.getName();
				case 2:
					return q;
				case 3:
					return q * med.getPrice();
				}
				
			}
			i++;
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		Integer val = (Integer) aValue;
		if (val < 1)
			return;
		int i = 0;
		for (String id : prescription.getMeds().keySet()) {
			if (i == rowIndex) {
				prescription.getMeds().put(id, val);
			}
			i++;
		}
	}

}
