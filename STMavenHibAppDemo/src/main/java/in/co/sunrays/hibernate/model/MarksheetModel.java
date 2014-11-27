package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.MarksheetPOJO;
import in.co.sunrays.hibernate.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Contains service methods of Marksheet. Manipulate ST_Marksheet table using
 * MarksheetPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class MarksheetModel {

	private static Logger log = Logger.getLogger(MarksheetModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * Adds Marksheet
	 * 
	 * @param pojo
	 * @return
	 */

	public long add(MarksheetPOJO pojo) {
		log.debug("Model add Started");
		long pk = 0;

		Session session = factory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			pk = (Long) session.save(pojo);
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

		log.debug("Model add End");
		return pk;
	}

	/**
	 * Updates Marksheet
	 * 
	 * @param pojo
	 * @return
	 */

	public void update(MarksheetPOJO pojo) {
		log.debug("Model update Started");
		Transaction transaction = null;
		Session session = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(pojo);
			transaction.commit();
		} catch (HibernateException e) {
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
	 * Deletes Marksheet
	 * 
	 * @param pojo
	 * @return
	 */

	public void delete(MarksheetPOJO pojo) {
		log.debug("Model delete Started");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.delete(pojo);
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
	 * Finds Marksheet by its name.
	 * 
	 * @param pojo
	 * @return
	 */

	public MarksheetPOJO findByName(String name) {
		log.debug("Model findByName Started");
		Session session = null;
		MarksheetPOJO pojo = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(MarksheetPOJO.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() == 1) {
				pojo = (MarksheetPOJO) list.get(0);
			}
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByName End");
		return pojo;
	}

	/**
	 * Finds Marksheet by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */

	public MarksheetPOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		MarksheetPOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (MarksheetPOJO) session.get(MarksheetPOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * searches Marksheet as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */

	public List search(MarksheetPOJO pojo) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(MarksheetPOJO.class);
			if (pojo.getId() > 0) {
				criteria.add(Restrictions.eq("id", pojo.getId()));
			}
			if (pojo.getName() != null && pojo.getName().length() > 0) {
				criteria.add(Restrictions.like("name", pojo.getName() + "%"));
			}
			if (pojo.getRollNo() != null && pojo.getRollNo().length() > 0) {
				criteria.add(Restrictions.like("roll", pojo.getRollNo() + "%"));
			}
			list = criteria.list();
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
