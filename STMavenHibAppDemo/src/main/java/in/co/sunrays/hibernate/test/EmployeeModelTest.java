package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.EmployeeModel;
import in.co.sunrays.hibernate.pojo.AddressPOJO;
import in.co.sunrays.hibernate.pojo.EmployeePOJO;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test program of EmployeeModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class EmployeeModelTest {
	EmployeeModel model = new EmployeeModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Employee setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Employee tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Employee setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Employee tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {
		AddressPOJO addressPOJO=new AddressPOJO();
		EmployeePOJO pojo = new EmployeePOJO();
		
		
		pojo.setFirstName("test");
		pojo.setLastName("test");
		addressPOJO.setCity("indore");
		addressPOJO.setEmail("test@gmail.com");
		addressPOJO.setState("mp");
		addressPOJO.setStreet("bhawerkuan");
		addressPOJO.setZip("452001");
		
		pojo.setAddress(addressPOJO);
		long pk = model.add(pojo);
		pojo = model.findByPK(pk);

		assertNotNull("Error : Employee Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		EmployeePOJO pojo = model.findByPK(1l);

		pojo.setFirstName("Alok");
		pojo.setLastName("Mishra");
		model.update(pojo);
		EmployeePOJO updatedDTO = model.findByPK(1l);

		assertEquals("Error : Employee Update Fail", pojo.getValue(),
				updatedDTO.getValue());

	}

	@Test
	public void testDelete() throws Exception {
		EmployeePOJO pojo = new EmployeePOJO();
		pojo.setId(2l);
		model.delete(pojo);

		pojo = model.findByPK(pojo.getId());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Employee Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		EmployeePOJO pojo = model.findByPK(1l);

		assertNotNull("Error : Employee Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstName());
			System.out.println(pojo.getLastName());
			System.out.println(pojo.getAddress());
		}

	}

	@Test
	public void testSearchEmployeePOJO() throws Exception {

		EmployeePOJO pojo = new EmployeePOJO();
		pojo.setFirstName("te");

		List<EmployeePOJO> list = model.search(pojo);

		assertTrue("Error : Test Search Fail", list.size() > 0);

	}

}
