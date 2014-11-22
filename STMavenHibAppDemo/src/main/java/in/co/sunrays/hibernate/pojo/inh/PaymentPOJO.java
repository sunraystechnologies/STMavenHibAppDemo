package in.co.sunrays.hibernate.pojo.inh;

/**
 * Contains Payment attributes and accessor methods.
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class PaymentPOJO {
	private long paymentid;
	private int amount;
	public long getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(long paymentid) {
		this.paymentid = paymentid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
