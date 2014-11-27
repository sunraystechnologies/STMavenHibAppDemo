package in.co.sunrays.hibernate.pojo.inh;

/**
 * Contains ChaqueHierarchy attributes and accessor methods.
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class ChaqueHierarchyPOJO extends PaymentHierarchyPOJO {

	private int chaquenumber;
	private String bankname;

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public int getChaquenumber() {
		return chaquenumber;
	}

	public void setChaquenumber(int chaquenumber) {
		this.chaquenumber = chaquenumber;
	}
}
