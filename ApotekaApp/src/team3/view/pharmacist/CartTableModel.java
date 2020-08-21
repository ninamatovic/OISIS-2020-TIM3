package team3.view.pharmacist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import team3.Database;
import team3.model.Prescription;
import team3.model.SellInfoItem;

public class CartTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private static Database database = Database.getInstance();
	private List<String> kolone = new ArrayList<String>();

	public CartTableModel() {
		kolone.add("Šifra leka");
		kolone.add("Kolièina");
		kolone.add("Cena");
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getRowCount() {
		return database.getCart().getItems().size();
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

		}
		return null;
	}

	@Override

	public Object getValueAt(int rowIndex, int columnIndex) {
		SellInfoItem med = database.getCart().getItems().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return med.getMedId();

		case 1:
			return med.getQuantity();

		case 2:
			return med.getPrice() * med.getQuantity();

		}

		return null;
	}

}
