package team3.view.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import team3.Database;
import team3.model.Medicine;
import team3.model.User;

public class MedicineTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private static Database database = Database.getInstance();
	private List<String> kolone = new ArrayList<String>();

	public MedicineTableModel() {
		kolone.add("Šifra leka");
		kolone.add("Naziv");
		kolone.add("Proizvoðaè");
		kolone.add("Recept");
		kolone.add("Cena");
		kolone.add("Izbrisan");
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public int getRowCount() {
		return database.getMedicine().size();
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
		case 2:
			return String.class;
		case 3:
		case 5:
			return Boolean.class;
		case 4:
			return Float.class;

		}
		return null;
	}

	@Override

	public Object getValueAt(int rowIndex, int columnIndex) {
		Medicine med = database.getMedicine().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return med.getId();

		case 1:
			return med.getName();

		case 2:
			return med.getMadeBy();
		case 3:
			return med.isPrescription();
		case 4:
			return med.getPrice();
		case 5:
			return med.isRemoved();

		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// super.setValueAt(aValue, rowIndex, columnIndex);
		Medicine med = database.getMedicine().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return;
		case 1:
			String v = (String) aValue;
			if (!v.equals(""))
				med.setName(v);
			break;
		case 2:
			String v1 = (String) aValue;
			med.setMadeBy(v1);
			break;
		case 3:

			med.setPrescription((boolean) aValue);
			break;
		case 4:
			Float price = (Float) aValue;
			if (price > 0)
				med.setPrice(price);
			break;
		case 5:
			med.setRemoved((boolean) aValue);
			break;

		}
		Database.save(database.getMedicine(), "./medicine.data");

	}

}
