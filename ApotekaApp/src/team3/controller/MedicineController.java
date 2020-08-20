package team3.controller;

import team3.Database;
import team3.model.Medicine;

public class MedicineController {

	public static String add(Medicine med) {
		String error = validate(med);
		if (!error.equals(""))
			return error;
		Database d = Database.getInstance();
		d.getMedicine().add(med);
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
			message += "Šifra nije uneta\r\n";
		if (med.getMadeBy().equals(""))
			message += "Proizvoðaè nije unet\r\n";
		if (med.getPrice() <= 0)
			message += "Cena nije validna\r\n";
		if (MedicineController.isIdTaken(med.getId()))
			message += "Sifra veæ posotji\r\n";
		return message;
	}

}
