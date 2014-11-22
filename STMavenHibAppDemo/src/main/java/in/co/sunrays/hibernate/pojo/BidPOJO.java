package in.co.sunrays.hibernate.pojo;

/**
 * Contains Bid attributes and accessor methods. BidPOJO has many-to-one
 * relation with AuctionItemPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URl www.sunrays.co.in
 */

public class BidPOJO {

	long id;
	int amount;
	String timestamp;
	int itemId;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
