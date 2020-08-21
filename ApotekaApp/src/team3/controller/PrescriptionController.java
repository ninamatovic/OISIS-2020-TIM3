package team3.controller;

import java.util.Date;
import java.util.Map;

import team3.Database;
import team3.model.Medicine;
import team3.model.Prescription;

public class PrescriptionController {

	public static void add(Medicine med, int quant) {
		Map<String, Integer> meds = Database.getInstance().getPrescription().getMeds();
		Integer q = meds.get(med.getId());
		if (q != null) {
			quant += q;
		}
		meds.put(med.getId(), quant);
	}

	public static void create() {
		Prescription p = Database.getInstance().getPrescription();
		p.setDate(new Date());
		p.setDoctor(Database.getInstance().getLoggedIn().getUsername());
		p.setId(Database.getInstance().getPrescriptions().size() + 1);
		p.setTotalPrice(totalPrice(p));
		Database.getInstance().setPrescription(new Prescription());
		Database.getInstance().getPrescriptions().add(p);
	}

	public static void remove(int r) {
		Prescription p = Database.getInstance().getPrescription();
		int i = 0;
		for (String id : p.getMeds().keySet()) {
			if (i == r) {
				p.getMeds().remove(id);
				return;
			}
			i++;
		}

	}

	public static Float totalPrice(Prescription p) {
		Float ret = 0f;
		for (String a : p.getMeds().keySet()) {
			Medicine med = MedicineController.getById(a);
			ret += p.getMeds().get(a) * med.getPrice();
		}
		return ret;
	}

	public static Prescription getById(int id) {
		return Database.getInstance().getPrescriptions().stream().filter(p -> !p.isRemoved() && p.getId() == id)
				.findFirst().orElse(null);
	}

}
