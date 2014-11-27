package in.co.sunrays.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import in.co.sunrays.hibernate.model.AuctionItemModel;
import in.co.sunrays.hibernate.pojo.rel.AuctionItemPOJO;
import in.co.sunrays.hibernate.pojo.rel.BidPOJO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

		AuctionItemPOJO auctionItemPOJO = new AuctionItemPOJO();

		auctionItemPOJO.setDescription("test Item");

		bidPOJO.setAmount(200);
		bidPOJO.setTimestamp("11:30:11");
		bidPOJO.setItemId(1);

		Set<BidPOJO> itemsSet = new HashSet<BidPOJO>();
		itemsSet.add(bidPOJO);
		auctionItemPOJO.setBids(itemsSet);

		long pk = model.add(auctionItemPOJO);
		auctionItemPOJO = model.findByPK(pk);

		assertNotNull("Error : AuctionItem Add Fail", auctionItemPOJO);
	}

	@Test
	public void testUpdate() throws Exception {

		AuctionItemPOJO auctionItemPOJO = model.findByPK(1l);

		auctionItemPOJO.setDescription("test Item update");
		model.update(auctionItemPOJO);
		AuctionItemPOJO updatedPOJO = model.findByPK(1l);

		assertEquals("Error : AuctionItem Update Fail",
				auctionItemPOJO.getDescription(), updatedPOJO.getDescription());

	}

	@Test
	public void testDelete() throws Exception {
		AuctionItemPOJO auctionItemPOJO = new AuctionItemPOJO();
		auctionItemPOJO.setId(2l);
		model.delete(auctionItemPOJO);

		auctionItemPOJO = model.findByPK(auctionItemPOJO.getId());

		assertNull("Error : Delete Test Fail", auctionItemPOJO);

		System.out.println("Success : AuctionItem Delete Success");
	}

	@Ignore
	public void testFindByPK() throws Exception {

		AuctionItemPOJO auctionItemPOJO = model.findByPK(1l);

		assertNotNull("Error : AuctionItem Get By Id Fail", auctionItemPOJO);

		if (auctionItemPOJO != null) {

			System.out.println(auctionItemPOJO.getId());
			System.out.println(auctionItemPOJO.getDescription());

		}

	}

	@Test
	public void testSearchAuctionItemPOJO() throws Exception {

		AuctionItemPOJO auctionItemPOJO = new AuctionItemPOJO();
		auctionItemPOJO.setDescription("te");

		List<AuctionItemPOJO> list = model.search(auctionItemPOJO);

		assertTrue("Error : AuctionItem Search Fail", list.size() > 0);

	}

}
