package team3.model;

//kolona u izvestaju
public class ReportItem {
	private float totalPrice;
	private String title, id;
	private int quantity;

	public ReportItem(float totalPrice, String title, int quantity, String id) {
		super();
		this.totalPrice = totalPrice;
		this.title = title;
		this.quantity = quantity;
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}