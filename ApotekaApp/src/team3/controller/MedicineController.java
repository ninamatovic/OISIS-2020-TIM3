package team3.controller;

import java.util.List;
import java.util.stream.Collectors;

import team3.Database;
import team3.model.Medicine;

public class MedicineController {

	public static String add(Medicine med) {
		String error = validate(med);
		if (!error.equals(""))
			return error;
		Database d = Database.getInstance();
		d.getMedicine().add(med);
		Database.save(d.getMedicine(),"./medicine.data");
		return "";
	}

	private static boolean isIdTaken(String name) {
		Database d = Database.getInstance();
		for (Medicine med : d.getMedicine()) {
			if (med.getId().equals(name))
				return true;
		}
		return false;
	}

	public static String validate(Medicine med) {
		String message = "";
		if (med.getName().equals(""))
			message += "Ime nije uneto\r\n";
		if (med.getId().equals(""))
			message += "�ifra nije uneta\r\n";
		if (med.getMadeBy().equals(""))
			message += "Proizvo�a� nije unet\r\n";
		if (med.getPrice() <= 0)
			message += "Cena nije validna\r\n";
		if (MedicineController.isIdTaken(med.getId()))
			message += "Sifra ve� posotji\r\n";
		return message;
	}

	public static List<Medicine> getAll() {
		return Database.getInstance().getMedicine().stream().filter(med -> !med.isRemoved())
				.collect(Collectors.toList());
	}

	public static Medicine getById(String id) {
		return Database.getInstance().getMedicine().stream().filter(med -> med.getId().equals(id)).findFirst()
				.orElse(null);
	}

	public static Medicine[] getNoPrescription() {
		return (Medicine[]) Database.getInstance().getMedicine().stream()
				.filter(item -> !item.isRemoved() && !item.isPrescription()).collect(Collectors.toList())
				.toArray(new Medicine[0]);
	}

	public static List<String> geAllManuf() {
		return Database.getInstance().getMedicine().stream().map(item -> item.getMadeBy()).distinct()
				.collect(Collectors.toList());
	}

}
