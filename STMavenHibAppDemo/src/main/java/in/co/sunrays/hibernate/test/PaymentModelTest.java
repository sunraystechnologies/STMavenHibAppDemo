package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import in.co.sunrays.hibernate.model.PaymentModel;
import in.co.sunrays.hibernate.pojo.inh.ChaquePOJO;
import in.co.sunrays.hibernate.pojo.inh.PaymentPOJO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test program of PaymentModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class PaymentModelTest {
	PaymentModel model = new PaymentModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Payment setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Payment tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Payment setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Payment tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {
		ChaquePOJO pojo = new ChaquePOJO();
		pojo.setAmount(5000);
		pojo.setBankname("SBI");
		pojo.setChaquenumber(123457);
		long pk = model.add(pojo);

		pojo = (ChaquePOJO) model.findByPK(pk);

		assertNotNull("Error : Payment Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		ChaquePOJO pojo = (ChaquePOJO) model.findByPK(1l);

		pojo.setAmount(6000);
		pojo.setBankname("PNB");
		pojo.setChaquenumber(987654);
		model.update(pojo);
		PaymentPOJO updatedPOJO = model.findByPK(1l);

		assertEquals("Error : Payment Update Fail", pojo.getAmount(),
				updatedPOJO.getAmount());

	}

	@Test
	public void testDelete() throws Exception {
		ChaquePOJO pojo = new ChaquePOJO();
		pojo.setPaymentid(1l);
		model.delete(pojo);

		pojo = (ChaquePOJO) model.findByPK(pojo.getPaymentid());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Payment Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		ChaquePOJO pojo = (ChaquePOJO) model.findByPK(1l);

		assertNotNull("Error : Payment Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getPaymentid());
			System.out.println(pojo.getAmount());
			System.out.println(pojo.getBankname());
		}

	}

}
