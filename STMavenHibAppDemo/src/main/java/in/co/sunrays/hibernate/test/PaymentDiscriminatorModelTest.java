package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import in.co.sunrays.hibernate.model.PaymentDiscriminatorModel;
import in.co.sunrays.hibernate.pojo.inh.ChaqueDiscriminatorPOJO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of PaymentDiscriminatorModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class PaymentDiscriminatorModelTest {
	PaymentDiscriminatorModel model = new PaymentDiscriminatorModel();

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
		ChaqueDiscriminatorPOJO pojo = new ChaqueDiscriminatorPOJO();
		pojo.setAmount(2000);
		pojo.setBankname("BOB");
		pojo.setChaquenumber(2354677);
		long pk = model.add(pojo);

		pojo = (ChaqueDiscriminatorPOJO) model.findByPK(pk);

		assertNotNull("Error : Payment Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		ChaqueDiscriminatorPOJO pojo = (ChaqueDiscriminatorPOJO) model
				.findByPK(1l);

		pojo.setAmount(3000);
		pojo.setBankname("sbi");
		pojo.setChaquenumber(367574486);
		model.update(pojo);
		ChaqueDiscriminatorPOJO updatedPOJO = (ChaqueDiscriminatorPOJO) model
				.findByPK(1l);

		assertEquals("Error : Payment Update Fail", pojo.getAmount(),
				updatedPOJO.getAmount());

	}

	@Test
	public void testDelete() throws Exception {
		ChaqueDiscriminatorPOJO pojo = new ChaqueDiscriminatorPOJO();
		pojo.setPaymentid(1l);
		model.delete(pojo);

		pojo = (ChaqueDiscriminatorPOJO) model.findByPK(pojo.getPaymentid());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Payment Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		ChaqueDiscriminatorPOJO pojo = (ChaqueDiscriminatorPOJO) model
				.findByPK(1l);

		assertNotNull("Error : Payment Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getPaymentid());
			System.out.println(pojo.getAmount());
			System.out.println(pojo.getBankname());
		}

	}

}
