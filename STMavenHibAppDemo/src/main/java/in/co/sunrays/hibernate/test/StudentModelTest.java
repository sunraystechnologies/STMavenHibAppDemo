package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.StudentModel;
import in.co.sunrays.hibernate.pojo.StudentPOJO;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test program of StudentModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class StudentModelTest {

	StudentModel model = new StudentModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Student setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Student tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Student setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Student tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {

		StudentPOJO studentPOJO = new StudentPOJO();

		//studentPOJO.setId(1l);
		studentPOJO.setFirstName("test");
		studentPOJO.setLastName("test");
		studentPOJO.setMobileNo(8817982453l);
		//studentPOJO.setBranchId(1l);

		long pk = model.add(studentPOJO);
		studentPOJO = model.findByPK(pk);
		assertNotNull("Error : Student Add Fail", studentPOJO);
	}

	@Ignore
	public void testUpdate() throws Exception {

		StudentPOJO studentPOJO = model.findByPK(1l);

		studentPOJO.setFirstName("testhello");
		studentPOJO.setLastName("testhello");
		studentPOJO.setMobileNo(9876543210l);
		model.update(studentPOJO);

		StudentPOJO updatedPOJO = model.findByPK(1l);

		assertEquals("Error : Student Update Fail", studentPOJO.getFirstName(),
				updatedPOJO.getFirstName());

	}

	@Ignore
	public void testDelete() throws Exception {
		StudentPOJO studentPOJO = new StudentPOJO();

		studentPOJO.setId(1l);
		model.delete(studentPOJO);

		studentPOJO = model.findByPK(studentPOJO.getId());

		assertNull("Error : Delete Test Fail", studentPOJO);

		System.out.println("Success : Student Delete Success");
	}

	@Ignore
	public void testFindByPK() throws Exception {

		StudentPOJO studentPOJO = model.findByPK(1l);

		assertNotNull("Error : Student Get By Id Fail", studentPOJO);

		if (studentPOJO != null) {

			System.out.println(studentPOJO.getId());
			System.out.println(studentPOJO.getFirstName());
			System.out.println(studentPOJO.getLastName());
		}

	}

	@Ignore
	public void testSearchStudentPOJO() throws Exception {

		StudentPOJO studentPOJO = new StudentPOJO();
		studentPOJO.setFirstName("t");

		List<StudentPOJO> list = model.search(studentPOJO);

		assertTrue("Error : Student Search Fail", list.size() > 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			studentPOJO = (StudentPOJO) it.next();
			System.out.println(studentPOJO.getFirstName());
		}
	}

}
