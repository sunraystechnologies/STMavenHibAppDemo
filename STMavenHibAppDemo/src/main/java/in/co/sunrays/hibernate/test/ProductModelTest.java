package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.ProductModel;
import in.co.sunrays.hibernate.pojo.ProductPOJO;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test program of ProductModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class ProductModelTest {

	ProductModel model = new ProductModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Product setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Product tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Product setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Product tearDown is called");
	}

	@Test
	public void testlistMarksheetPOJO() throws Exception {

		List list = (List) model.list();

		assertTrue("Error : Test List Fail", list.size() > 0);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			ProductPOJO pojo = (ProductPOJO) it.next();
			System.out.println(pojo.getProductName());
		}

	}

}
