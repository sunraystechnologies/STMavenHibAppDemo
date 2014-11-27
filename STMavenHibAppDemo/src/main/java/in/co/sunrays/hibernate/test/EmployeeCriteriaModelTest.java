package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.EmployeeCriteriaModel;
import in.co.sunrays.hibernate.pojo.rel.EmployeePOJO;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of EmployeeCriteriaModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class EmployeeCriteriaModelTest {

	EmployeeCriteriaModel model = new EmployeeCriteriaModel();

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
	public void testlistEmployeePOJO() throws Exception {

		List list = (List) model.list();

		assertTrue("Error : Test List Fail", list.size() > 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			EmployeePOJO pojo = (EmployeePOJO) it.next();
			System.out.println(pojo.getValue());
		}

	}

	@Test
	public void testSearchEmployeePOJO() throws Exception {

		EmployeePOJO pojo = new EmployeePOJO();
		pojo.setFirstName("D");

		List<EmployeePOJO> list = model.search(pojo);

		assertTrue("Error : Employee Search Fail", list.size() > 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			pojo = (EmployeePOJO) it.next();
			System.out.println(pojo.getValue());
		}

	}

	@Test
	public void testjoinlistEmployeePOJO() throws Exception {

		List list = (List) model.joinlist();

		assertTrue("Error : Test List Fail", list.size() > 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			EmployeePOJO employeePOJO = (EmployeePOJO) it.next();
			System.out.println(employeePOJO.getValue());
		}

	}
}
