package in.co.sunrays.hibernate.pojo.inh;

/**
 * Contains CreditCardHierarchy attributes and accessor methods.
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class CreditCardHierarchyPOJO extends PaymentHierarchyPOJO {
	private int cctype;

	public int getCctype() {
		return cctype;
	}

	public void setCctype(int cctype) {
		this.cctype = cctype;
	}
}
