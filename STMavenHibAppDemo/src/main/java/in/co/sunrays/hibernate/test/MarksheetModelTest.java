package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.MarksheetModel;
import in.co.sunrays.hibernate.pojo.MarksheetPOJO;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of MarksheetModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class MarksheetModelTest {

	MarksheetModel model = new MarksheetModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Marksheet setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Marksheet tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Marksheet setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Marksheet tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {

		MarksheetPOJO marksheetPOJO = new MarksheetPOJO();

		marksheetPOJO.setRollNo("101");
		marksheetPOJO.setName("test");
		marksheetPOJO.setPhysics(58);
		marksheetPOJO.setChemistry(76);
		marksheetPOJO.setMaths(78);

		long pk = model.add(marksheetPOJO);
		marksheetPOJO = model.findByPK(pk);
		assertNotNull("Error : Marksheet Add Fail", marksheetPOJO);
	}

	@Test
	public void testUpdate() throws Exception {

		MarksheetPOJO marksheetPOJO = model.findByPK(1l);

		marksheetPOJO.setName("test1");
		marksheetPOJO.setMaths(87);
		marksheetPOJO.setChemistry(67);
		model.update(marksheetPOJO);
		MarksheetPOJO updatedPOJO = model.findByPK(1l);

		assertEquals("Error : Marksheet Update Fail",
				marksheetPOJO.getChemistry(), updatedPOJO.getChemistry());

	}

	@Test
	public void testDelete() throws Exception {
		MarksheetPOJO marksheetPOJO = new MarksheetPOJO();

		marksheetPOJO.setId(1l);
		model.delete(marksheetPOJO);

		marksheetPOJO = model.findByPK(marksheetPOJO.getId());

		assertNull("Error : Delete Test Fail", marksheetPOJO);

		System.out.println("Success : Marksheet Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		MarksheetPOJO marksheetPOJO = model.findByPK(1l);

		assertNotNull("Error : Marksheet Get By Id Fail", marksheetPOJO);

		if (marksheetPOJO != null) {

			System.out.println(marksheetPOJO.getId());
			System.out.println(marksheetPOJO.getRollNo());
			System.out.println(marksheetPOJO.getName());
		}

	}

	@Test
	public void testSearchMarksheetPOJO() throws Exception {

		MarksheetPOJO pojo = new MarksheetPOJO();
		pojo.setName("t");

		List<MarksheetPOJO> list = model.search(pojo);

		assertTrue("Error : Marksheet Search Fail", list.size() > 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			pojo = (MarksheetPOJO) it.next();
			System.out.println(pojo.getName());
		}
	}

}
