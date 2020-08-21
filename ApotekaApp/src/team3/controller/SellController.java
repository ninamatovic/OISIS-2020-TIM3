package team3.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import team3.Database;
import team3.model.Medicine;
import team3.model.Prescription;
import team3.model.SellInfo;
import team3.model.SellInfoItem;

public class SellController {
	public static void addToCart(Medicine med, int quantity) {
		SellInfo cart = Database.getInstance().getCart();
		int i = 0;
		List<SellInfoItem> items = cart.getItems();
		for (; i < items.size(); i++) {
			SellInfoItem item = items.get(i);
			if (item.getMedId().equals(med.getId())) {
				int q = item.getQuantity();
				float p = item.getPrice();
				p = (q + quantity) * (p / q);
				item.setQuantity(quantity);
				item.setPrice(p);
			}
		}

	}

	public static void addPrescriptionToCart(Prescription r) {
		for (String a : r.getMeds().keySet()) {
			Medicine med = MedicineController.getById(a);
			addToCart(med, r.getMeds().get(a));
		}
	}

	public static int calculatePercentOff(String name) {
		if (name == null || name.equals(""))
			return 0;
		Date now = new Date();
		int month = now.getMonth();
		int year = now.getYear();
		double totalSpentThisMonth = Database.getInstance().getSells().stream()
				.filter(item -> item.getBuyer().equals(name))
				.filter(item -> item.getDate().getMonth() == month && item.getDate().getYear() == year)
				.mapToDouble(item -> item.getPrice() * (1 - item.getPercentOff() / 100)).sum();
		if (totalSpentThisMonth >= 5000)
			return 20;
		if (totalSpentThisMonth >= 1000)
			return 10;
		return 5;
	}

	public static void buy() {
		SellInfo a = Database.getInstance().getCart();
		a.setDate(new Date());
		a.setPercentOff(calculatePercentOff(a.getBuyer()));
		Database.getInstance().getSells().add(a);
		Database.getInstance().setCart(new SellInfo());
	}

}