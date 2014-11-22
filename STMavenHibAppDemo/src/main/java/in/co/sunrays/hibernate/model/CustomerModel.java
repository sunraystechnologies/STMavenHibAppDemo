package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.CustomerPOJO;

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
 * Contains service methods of Customer. Manipulate Customer table using
 * CustomerPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */
public class CustomerModel {

	private static Logger log = Logger.getLogger(CustomerModel.class);

	SessionFactory factory = new Configuration().configure()
			.buildSessionFactory();

	/**
	 * Adds Customer
	 * 
	 * @param pojo
	 * @return
	 */
	public long add(CustomerPOJO pojo) {
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
	 * Updates Customer
	 * 
	 * @param pojo
	 * @return
	 */
	public void update(CustomerPOJO pojo) {
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
	 * Deletes Customer
	 * 
	 * @param pojo
	 * @return
	 */
	public void delete(CustomerPOJO pojo) {
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
	 * Finds Customer by its name.
	 * 
	 * @param pojo
	 * @return
	 */
	public CustomerPOJO findByName(String name) {
		log.debug("Model findByName Started");
		Session session = null;
		CustomerPOJO pojo = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(CustomerPOJO.class);
			criteria.add(Restrictions.eq("companyName", name));
			List list = criteria.list();
			if (list.size() == 1) {
				pojo = (CustomerPOJO) list.get(0);
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
	 * Finds Customer by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */
	public CustomerPOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		CustomerPOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (CustomerPOJO) session.get(CustomerPOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * searches Customer as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */
	public List search(CustomerPOJO pojo, int pageNo, int pageSize) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(CustomerPOJO.class);
			if (pojo.getId() > 0) {
				criteria.add(Restrictions.eq("id", pojo.getId()));
			}
			if (pojo.getCompanyName() != null
					&& pojo.getCompanyName().length() > 0) {
				criteria.add(Restrictions.like("companyName",
						pojo.getCompanyName() + "%"));
			}
			if (pojo.getFirstName() != null && pojo.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", pojo.getFirstName()
						+ "%"));
			}
			if (pojo.getLastName() != null && pojo.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", pojo.getLastName()
						+ "%"));
			}
			if (pojo.getAddress() != null && pojo.getAddress().length() > 0) {
				criteria.add(Restrictions.like("address", pojo.getAddress()
						+ "%"));
			}
			if (pojo.getContactNo() > 0) {
				criteria.add(Restrictions.like("contactNo", pojo.getContactNo()));
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
	 * searches Customer as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */
	public List search(CustomerPOJO pojo) {
		// TODO Auto-generated method stub
		return search(pojo, 0, 0);
	}



}
