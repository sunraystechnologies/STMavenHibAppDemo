package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import in.co.sunrays.hibernate.model.PaymentHierarchyModel;
import in.co.sunrays.hibernate.pojo.inh.CreditCardHierarchyPOJO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of PaymentHierarchyModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class PaymentHierarchyModelTest {
	PaymentHierarchyModel model = new PaymentHierarchyModel();

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

		CreditCardHierarchyPOJO pojo = new CreditCardHierarchyPOJO();
		pojo.setAmount(2000);
		pojo.setCctype(123442);
		long pk = model.add(pojo);

		pojo = (CreditCardHierarchyPOJO) model.findByPK(pk);

		assertNotNull("Error : Payment Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		CreditCardHierarchyPOJO pojo = (CreditCardHierarchyPOJO) model
				.findByPK(1l);

		pojo.setAmount(4000);
		pojo.setCctype(453);
		;
		model.update(pojo);
		CreditCardHierarchyPOJO updatedPOJO = (CreditCardHierarchyPOJO) model
				.findByPK(1l);

		assertEquals("Error : Payment Update Fail", pojo.getAmount(),
				updatedPOJO.getAmount());

	}

	@Test
	public void testDelete() throws Exception {

		CreditCardHierarchyPOJO pojo = new CreditCardHierarchyPOJO();
		pojo.setPaymentid(1l);
		model.delete(pojo);

		pojo = (CreditCardHierarchyPOJO) model.findByPK(pojo.getPaymentid());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Payment Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		CreditCardHierarchyPOJO pojo = (CreditCardHierarchyPOJO) model
				.findByPK(1l);

		assertNotNull("Error : Payment Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getPaymentid());
			System.out.println(pojo.getAmount());
			System.out.println(pojo.getCctype());
		}

	}

}
