package in.co.sunrays.hibernate.pojo;

import java.util.Set;

/**
 * Contains AuctionItem attributes and accessor methods. AuctionItemPOJO has
 * one-to-many relation with BidPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in 
 */

public class AuctionItemPOJO {

	private long id;
	private Set bids;
	private String description;
	private BidPOJO successfulBid = null;

	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public BidPOJO getSuccessfulBid() {
		return successfulBid;
	}

	public void setSuccessfulBid(BidPOJO successfulBid) {
		this.successfulBid = successfulBid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
