package in.co.sunrays.hibernate.pojo.rel;

/**
 * Contains Phone attributes and accessor methods.
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class PhonePOJO {

	private Long phoneId;
	private Long phonenumber;

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
}
