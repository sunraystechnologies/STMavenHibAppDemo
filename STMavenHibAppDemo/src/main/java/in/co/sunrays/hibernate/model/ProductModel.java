package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Contains service methods of ProductModel. Manipulate ST_Product table using
 * ProductPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class ProductModel {

	private static Logger log = Logger.getLogger(ProductModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * List Product
	 * 
	 * @return
	 */

	public List list() {

		log.debug("Model list Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("allProduct");
			list = query.list();
			System.out.println("size" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return list;
	}

}
