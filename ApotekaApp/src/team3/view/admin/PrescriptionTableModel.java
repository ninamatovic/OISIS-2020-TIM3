package team3.view.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import team3.Database;
import team3.model.Prescription;

public class PrescriptionTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private static Database database = Database.getInstance();
	private List<String> kolone = new ArrayList<String>();

	public PrescriptionTableModel() {
		kolone.add("Šifra");
		kolone.add("Datum");
		kolone.add("Lekar");
		kolone.add("Pacijent");
		kolone.add("Cena");
		kolone.add("Izbrisan");
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 5;
	}

	@Override
	public int getRowCount() {
		return database.getPrescriptions().size();
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
		case 3:
		case 2:
			return String.class;
		case 1:
			return String.class;
		case 4:
			return Float.class;
		case 5:
			return Boolean.class;

		}
		return null;
	}

	@Override

	public Object getValueAt(int rowIndex, int columnIndex) {
		Prescription med = database.getPrescriptions().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return med.getId();

		case 1:

			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			return f.format(med.getDate());

		case 2:
			return med.getDoctor();
		case 3:
			return med.getPatientId();
		case 4:
			return med.getTotalPrice();
		case 5:
			return med.isRemoved();

		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		database.getPrescriptions().get(rowIndex).setRemoved((boolean) aValue);
		Database.save(database.getPrescriptions(), "./prescriptions.data");

	}

}
