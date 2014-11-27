package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.StudentPOJO;
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
 * Contains service methods of Student. Manipulate ST_Student table using
 * StudentPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class StudentModel {

	private static Logger log = Logger.getLogger(StudentModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * Adds Student
	 * 
	 * @param pojo
	 * @return
	 */

	public long add(StudentPOJO pojo) {
		log.debug("Model add Started");
		long pk = 0;

		Session session = factory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			pk = (Long) session.save(pojo);
			transaction.commit();
		} catch (Exception e) {
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
	 * Updates Student
	 * 
	 * @param pojo
	 * @return
	 */

	public void update(StudentPOJO pojo) {
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
	 * Deletes Student
	 * 
	 * @param pojo
	 * @return
	 */

	public void delete(StudentPOJO pojo) {
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
	 * Finds Student by its name.
	 * 
	 * @param pojo
	 * @return
	 */

	public StudentPOJO findByName(String name) {
		log.debug("Model findByName Started");
		Session session = null;
		StudentPOJO pojo = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(StudentPOJO.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() == 1) {
				pojo = (StudentPOJO) list.get(0);
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
	 * Finds Student by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */

	public StudentPOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		StudentPOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (StudentPOJO) session.get(StudentPOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * searches Student as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */

	public List search(StudentPOJO pojo) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(StudentPOJO.class);
			if (pojo.getId() > 0) {
				criteria.add(Restrictions.eq("id", pojo.getId()));
			}
			if (pojo.getFirstName() != null && pojo.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", pojo.getFirstName()
						+ "%"));
			}
			if (pojo.getLastName() != null && pojo.getLastName().length() > 0) {
				criteria.add(Restrictions.like("roll", pojo.getLastName() + "%"));
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
