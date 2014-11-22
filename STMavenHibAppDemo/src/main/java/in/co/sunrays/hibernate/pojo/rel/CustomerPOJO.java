package in.co.sunrays.hibernate.pojo.rel;

/**
 * Contains Customer attributes and accessor methods.
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class CustomerPOJO {

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String companyName;
	private PhonePOJO phones;

	public PhonePOJO getPhones() {
		return phones;
	}

	public void setPhones(PhonePOJO phones) {
		this.phones = phones;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long contactNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return firstName + " " + lastName;
	}

}
