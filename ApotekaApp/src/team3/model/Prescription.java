package team3.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Prescription {

	private int id;
	private String doctor, patientId;
	private Date date;
	private Map<String, Integer> meds = new LinkedHashMap<>();
	private float totalPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<String, Integer> getMeds() {
		return meds;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
