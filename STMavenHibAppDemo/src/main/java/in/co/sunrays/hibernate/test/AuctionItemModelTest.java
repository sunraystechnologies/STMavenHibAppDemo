package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.AuctionItemModel;
import in.co.sunrays.hibernate.pojo.AuctionItemPOJO;
import in.co.sunrays.hibernate.pojo.BidPOJO;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test program of AuctionItemModel
 * 
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class AuctionItemModelTest {

	AuctionItemModel model = new AuctionItemModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("AuctionItem setUpBeforeClass is called");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AuctionItem tearDownAfterClass is called");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("AuctionItem setUp is called");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("AuctionItem tearDown is called");
	}

	@Test
	public void testAdd() throws Exception {
		BidPOJO bidPOJO = new BidPOJO();
		AuctionItemPOJO pojo = new AuctionItemPOJO();

		pojo.setDescription("test");
		bidPOJO.setAmount(200);
		bidPOJO.setTimestamp("11:30");
		bidPOJO.setItemId(1);

		pojo.setSuccessfulBid(bidPOJO);
		long pk = model.add(pojo);
		pojo = model.findByPK(pk);

		assertNotNull("Error : AuctionItem Add Fail", pojo);
	}

	@Test
	public void testUpdate() throws Exception {

		AuctionItemPOJO pojo = model.findByPK(1l);

		pojo.setDescription("testffsd");
		model.update(pojo);
		AuctionItemPOJO updatedDTO = model.findByPK(1l);

		assertEquals("Error : AuctionItem Update Fail", pojo.getDescription(),
				updatedDTO.getDescription());

	}

	@Test
	public void testDelete() throws Exception {
		AuctionItemPOJO pojo = new AuctionItemPOJO();
		pojo.setId(2l);
		model.delete(pojo);

		pojo = model.findByPK(pojo.getId());

		assertNull("Error : Delete Test Fail", pojo);

		System.out.println("Success : AuctionItem Delete Success");
	}

	@Test
	public void testFindByPK() throws Exception {

		AuctionItemPOJO pojo = model.findByPK(1l);

		assertNotNull("Error : AuctionItem Get By Id Fail", pojo);

		if (pojo != null) {

			System.out.println(pojo.getId());
			System.out.println(pojo.getDescription());

		}

	}

	@Test
	public void testSearchAuctionItemPOJO() throws Exception {

		AuctionItemPOJO pojo = new AuctionItemPOJO();
		pojo.setDescription("te");

		List<AuctionItemPOJO> list = model.search(pojo);

		assertTrue("Error : AuctionItem Search Fail", list.size() > 0);

	}

}
