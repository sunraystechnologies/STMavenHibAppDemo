package in.co.sunrays.hibernate.model;

import java.util.List;
import in.co.sunrays.hibernate.pojo.rel.EmployeePOJO;
import in.co.sunrays.hibernate.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Contains service methods of EmployeeHQL. Manipulate ST_EMPLOYEE table using
 * EmployeePOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class EmployeeHQLModel {

	private static Logger log = Logger.getLogger(EmployeeHQLModel.class);
	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * Updates an Employee along with its Address
	 * 
	 * @param pojo
	 * @return
	 */

	public void update(EmployeePOJO pojo) {
		log.debug("Model update Started");
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("update EmployeePOJO set firstName = '"
							+ pojo.getFirstName() + "' where id = "
							+ pojo.getId());
			System.out.println(query);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		log.debug("Model update End");
	}

	/**
	 * Deletes an Employee along with its Address
	 * 
	 * @param pojo
	 * @return
	 */

	public void delete(EmployeePOJO pojo) {
		log.debug("Model delete Started");
		System.out.println(pojo.getId());
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("delete from EmployeePOJO where id = "
							+ pojo.getId());
			System.out.println(query);
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		log.debug("Model delete End");
	}

	/**
	 * Finds an Employee by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */

	public EmployeePOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		EmployeePOJO pojo = null;
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EmployeePOJO where id = "
					+ pk);
			list = (List) query.list();
			if (list.size() > 0) {
				pojo = (EmployeePOJO) list.get(0);
			}
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * Lists an Employee .
	 * 
	 * @param pojo
	 * @return
	 */

	public List list() {
		log.debug("Model list Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Query query = session.createQuery("from EmployeePOJO");
			query.setCacheable(true);
			list = (List) query.list();
			System.out.println("size" + list.size());
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return list;
	}

	/**
	 * Lists an Employee and Phone .
	 * 
	 * @param pojo
	 * @return
	 */

	public List joinlist() {
		log.debug("Model list Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Query query = session
					.createQuery("select e.id,e.firstName,p.phonenumber from EmployeePOJO e , PhonePOJO p where e.id=p.phoneId");
			list = (List) query.list();
			System.out.println("size" + list.size());
		} catch (Exception e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return list;
	}

}
