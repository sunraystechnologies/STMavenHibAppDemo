package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.EmployeePOJO;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Contains service methods of Employee. Manipulate Employee table using
 * EmployeePOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class EmployeeModel {

	private static Logger log = Logger.getLogger(EmployeeModel.class);

	SessionFactory factory = new Configuration().configure()
			.buildSessionFactory();

	/**
	 * Adds an Employee along with its Address
	 * 
	 * @param pojo
	 * @return
	 */
	public long add(EmployeePOJO pojo) {
		
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
	 * Deletes an Employee along with its Address
	 * 
	 * @param pojo
	 * @return
	 */
	public void delete(EmployeePOJO pojo) {
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
	 * Finds an Employee by its name.
	 * 
	 * @param pojo
	 * @return
	 */

	public EmployeePOJO findByName(String name) {
		log.debug("Model findByName Started");
		Session session = null;
		EmployeePOJO pojo = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(EmployeePOJO.class);
			criteria.add(Restrictions.eq("companyName", name));
			List list = criteria.list();
			if (list.size() == 1) {
				pojo = (EmployeePOJO) list.get(0);
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
	 * Finds an Employee by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */
	public EmployeePOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		EmployeePOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (EmployeePOJO) session.get(EmployeePOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * searches Employee as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */
	public List search(EmployeePOJO pojo, int pageNo, int pageSize) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(EmployeePOJO.class);
			if (pojo.getId() > 0) {
				criteria.add(Restrictions.eq("id", pojo.getId()));
			}
			
			if (pojo.getFirstName() != null && pojo.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", pojo.getFirstName()
						+ "%"));
			}
			if (pojo.getLastName() != null && pojo.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", pojo.getLastName()
						+ "%"));
			}
	

			// if page size is greater than zero the apply pagination
			if (pageSize > 0) {
				criteria.setFirstResult(((pageNo - 1) * pageSize));
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model search End");
		return list;
	}

	/**
	 * searches Employee as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */
	public List search(EmployeePOJO pojo) {
		// TODO Auto-generated method stub
		return search(pojo, 0, 0);
	}


}
