package team3.view.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;

import team3.model.ReportItem;

public class ReportTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	private List<String> kolone = new ArrayList<String>();
	private List<ReportItem> report;

	public ReportTableModel(List<ReportItem> report) {
		kolone.add("Šifra leka");
		this.report = report;
		kolone.add("Naziv leka");
		kolone.add("Kolièina");
		kolone.add("Profit");
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;// columnIndex >=4;
	}

	@Override
	public int getRowCount() {
		return report.size();
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
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Integer.class;
		case 3:
			return Float.class;
		case 4:
		default:
			return null;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int i = 0;
		ReportItem r = report.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return r.getId();

		case 1:
			return r.getTitle();
		case 2:
			return r.getQuantity();

		case 3:
			return r.getTotalPrice();

		}

		return null;
	}

}
