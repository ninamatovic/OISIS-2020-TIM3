package team3.view.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import team3.Database;
import team3.model.User;

public class UserTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private static Database database = Database.getInstance();
	private List<String> kolone = new ArrayList<String>();

	public UserTableModel() {
		kolone.add("Korsinièko ime");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Tip");
		kolone.add("Izbrisan");
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 4;
	}

	@Override
	public int getRowCount() {
		return database.getUsers().size();
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
		case 3:
			return String.class;
		case 4:
			return Boolean.class;
		default:
			return null;
		}
	}

	@Override

	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = database.getUsers().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getUsername();

		case 1:
			return user.getFirstName();

		case 2:
			return user.getLastName();
		case 3:
			return user.getRole();
		case 4:
			return user.isRemoved();

		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 4) {
			return;
		}
		database.getUsers().get(rowIndex).setRemoved((boolean) aValue);
		Database.save(database.getUsers(), "./users.data");

	}

}
