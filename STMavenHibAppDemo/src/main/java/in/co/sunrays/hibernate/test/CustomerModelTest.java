package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.CustomerModel;
import in.co.sunrays.hibernate.pojo.CustomerPOJO;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of CustomerModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class CustomerModelTest {

	CustomerModel model = new CustomerModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Customer setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Customer tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Customer setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Customer tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {
		CustomerPOJO pojo = new CustomerPOJO();
		pojo.setCompanyName("test6");
		;
		pojo.setFirstName("test");
		pojo.setLastName("test");
		pojo.setContactNo(8817982453l);
		pojo.setAddress("Sanver Road");
		long pk = model.add(pojo);

		pojo = model.findByPK(pk);

		assertNotNull("Error : Customer Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		CustomerPOJO pojo = model.findByPK(1l);

		pojo.setFirstName("Alok");
		pojo.setLastName("Mishra");
		model.update(pojo);
		CustomerPOJO updatedDTO = model.findByPK(1l);

		assertEquals("Error : Customer Update Fail", pojo.getValue(),
				updatedDTO.getValue());

	}

	@Test
	public void testDelete() throws Exception {
		CustomerPOJO pojo = new CustomerPOJO();
		pojo.setId(2l);
		model.delete(pojo);

		pojo = model.findByPK(pojo.getId());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Customer Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		CustomerPOJO pojo = model.findByPK(1l);

		assertNotNull("Error : Customer Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstName());
			System.out.println(pojo.getLastName());
			System.out.println(pojo.getCompanyName());
			System.out.println(pojo.getAddress());
			System.out.println(pojo.getContactNo());
		}

	}

	@Test
	public void testSearchCustomerPOJO() throws Exception {

		CustomerPOJO pojo = new CustomerPOJO();
		pojo.setCompanyName("te");

		List<CustomerPOJO> list = model.search(pojo);

		assertTrue("Error : Customer Search Fail", list.size() > 0);

	}

}
