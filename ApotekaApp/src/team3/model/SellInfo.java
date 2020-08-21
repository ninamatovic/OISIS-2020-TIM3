package team3.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SellInfo implements Serializable{
	private String buyer, seller;
	private float price;
	private int percentOff;
	private List<SellInfoItem> items = new LinkedList<SellInfoItem>();
	private Date date;

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPercentOff() {
		return percentOff;
	}

	public void setPercentOff(int percentOff) {
		this.percentOff = percentOff;
	}

	public List<SellInfoItem> getItems() {
		return items;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}
