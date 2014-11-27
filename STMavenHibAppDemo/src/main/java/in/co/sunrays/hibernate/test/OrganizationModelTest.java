package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.OrganizationModel;
import in.co.sunrays.hibernate.pojo.rel.OrganizationPOJO;
import in.co.sunrays.hibernate.pojo.rel.SupplierPOJO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of OrganizationModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class OrganizationModelTest {

	OrganizationModel model = new OrganizationModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Organization setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Organization tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Organization setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Organization tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {
		Set<SupplierPOJO> set = new HashSet<SupplierPOJO>();
		SupplierPOJO supplierPOJO = new SupplierPOJO();

		supplierPOJO.setName("suppliertest");
		supplierPOJO.setAdrress("suppliertest");
		supplierPOJO.setPhoneNo("4534533332");
		set.add(supplierPOJO);

		OrganizationPOJO organizationpojo = new OrganizationPOJO();

		organizationpojo.setName("org test");
		organizationpojo.setAdrress("org test");
		organizationpojo.setPhoneNo("1234554322");
		organizationpojo.setSuppliers(set);

		long pk = model.add(organizationpojo);
		organizationpojo = model.findByPK(pk);

		assertNotNull("Error : Organization Add Fail", organizationpojo);
	}

	@Test
	public void testUpdate() throws Exception {

		OrganizationPOJO pojo = model.findByPK(1l);

		pojo.setName("test org");
		pojo.setAdrress("indore");
		model.update(pojo);
		OrganizationPOJO updatedPOJO = model.findByPK(1l);

		assertEquals("Error : Organization Update Fail", pojo.getName(),
				updatedPOJO.getName());

	}

	@Test
	public void testDelete() throws Exception {

		OrganizationPOJO pojo = new OrganizationPOJO();
		pojo.setOrganizationId(2l);
		model.delete(pojo);

		pojo = model.findByPK(pojo.getOrganizationId());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : Organization Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		OrganizationPOJO pojo = model.findByPK(1l);

		assertNotNull("Error : Organization Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getOrganizationId());
			System.out.println(pojo.getName());

		}

	}

	@Test
	public void testSearchOrganizationPOJO() throws Exception {

		OrganizationPOJO pojo = new OrganizationPOJO();
		pojo.setName("te");

		List<OrganizationPOJO> list = model.search(pojo);

		assertTrue("Error : Organization Search Fail", list.size() > 0);

	}

}