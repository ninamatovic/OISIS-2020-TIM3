package team3.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import team3.Database;
import team3.model.Medicine;
import team3.model.ReportItem;
import team3.model.SellInfo;
import team3.model.SellInfoItem;

public class ReportsController {
	private ReportsController() {

	}

	public static List<ReportItem> getReport(String producer, String seller) {
		LinkedHashMap<String, ReportItem> ret = new LinkedHashMap<String, ReportItem>();
		for (SellInfo b : Database.getInstance().getSells()) {
			if (seller != null && !b.getSeller().equals(seller))
				continue;

			for (SellInfoItem bi : b.getItems()) {
				String medId = bi.getMedId();
				Medicine med = MedicineController.getById(medId);
				if (producer != null && !med.getMadeBy().equals(producer))
					continue;
				float profit = (float) (bi.getPrice() * (1.0 - b.getPercentOff() / 100f));
				if (ret.containsKey(medId)) {
					ReportItem rep = ret.get(medId);
					rep.setTotalPrice(rep.getTotalPrice() + profit);
					rep.setTotalPrice(rep.getQuantity() + bi.getQuantity());
				} else {

					ReportItem rep = new ReportItem(profit, med.getName(), bi.getQuantity(), bi.getMedId());
					ret.put(medId, rep);
				}
			}
		}

		return ret.values().stream().collect(Collectors.toList());
	}

}