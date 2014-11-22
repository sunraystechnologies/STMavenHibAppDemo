package in.co.sunrays.hibernate.model;

/**
 * Contains service methods of Organization. Manipulate Organization table using
 * OrganizationPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

import in.co.sunrays.hibernate.pojo.rel.OrganizationPOJO;
import in.co.sunrays.hibernate.util.HibernateUtil;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class OrganizationModel {
	private static Logger log = Logger.getLogger(OrganizationModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * Adds an Organization along with its Supplier
	 * 
	 * @param pojo
	 * @return
	 */

	public long add(OrganizationPOJO pojo) {

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
	 * Updates an Organization along with its Bids
	 * 
	 * @param pojo
	 * @return
	 */
	public void update(OrganizationPOJO pojo) {
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
	 * Deletes an Organization along with its Supplier
	 * 
	 * @param pojo
	 * @return
	 */
	public void delete(OrganizationPOJO pojo) {
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
	 * Finds an Organization by its name.
	 * 
	 * @param pojo
	 * @return
	 */

	public OrganizationPOJO findByName(String name) {
		log.debug("Model findByName Started");
		Session session = null;
		OrganizationPOJO pojo = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(OrganizationPOJO.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() == 1) {
				pojo = (OrganizationPOJO) list.get(0);
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
	 * Finds an Organization by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */

	public OrganizationPOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		OrganizationPOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (OrganizationPOJO) session.get(OrganizationPOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

	/**
	 * searches Organizations as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */

	public List search(OrganizationPOJO pojo, int pageNo, int pageSize) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(OrganizationPOJO.class);
			if (pojo.getOrganizationId() > 0) {
				criteria.add(Restrictions.eq("organizationid",
						pojo.getOrganizationId()));
			}

			if (pojo.getName() != null && pojo.getName().length() > 0) {
				criteria.add(Restrictions.like("name", pojo.getName() + "%"));
				if (pojo.getAdrress() != null && pojo.getAdrress().length() > 0) {
					criteria.add(Restrictions.like("address", pojo.getAdrress()
							+ "%"));
				}

				// if page size is greater than zero the apply pagination
				if (pageSize > 0) {
					criteria.setFirstResult(((pageNo - 1) * pageSize));
					criteria.setMaxResults(pageSize);
				}
				list = criteria.list();
			}
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
	 * searches Organizations as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */

	public List search(OrganizationPOJO pojo) {
		// TODO Auto-generated method stub
		return search(pojo, 0, 0);
	}
}