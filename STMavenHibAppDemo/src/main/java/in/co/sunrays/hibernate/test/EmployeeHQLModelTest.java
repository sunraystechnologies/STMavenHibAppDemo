package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.EmployeeHQLModel;
import in.co.sunrays.hibernate.pojo.rel.EmployeePOJO;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test program of EmployeeHQLModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class EmployeeHQLModelTest {

	EmployeeHQLModel model = new EmployeeHQLModel();

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
	public void testUpdate() throws Exception {

		EmployeePOJO pojo = model.findByPK(1l);
		pojo.setFirstName("Aloksdfg");
		pojo.setLastName("Mishra");
		System.out.println("start");
		model.update(pojo);
		EmployeePOJO updatedPOJO = model.findByPK(1l);
		assertEquals("Error : Employee Update Fail", pojo.getValue(),
				updatedPOJO.getValue());

	}

	@Ignore
	public void testDelete() throws Exception {
		EmployeePOJO pojo = new EmployeePOJO();
		pojo.setId(1l);
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
	public void testlistEmployeePOJO() throws Exception {

		List list = (List) model.list();

		assertTrue("Error : Test List Fail", list.size() > 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			EmployeePOJO pojo = (EmployeePOJO) it.next();
			System.out.println(pojo.getValue());
		}

	}
}
