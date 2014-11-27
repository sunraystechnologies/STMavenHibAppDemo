package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.inh.PaymentDiscriminatorPOJO;
import in.co.sunrays.hibernate.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Contains service methods of PaymentDiscriminator. Manipulate
 * ST_PAYMENT_DISCRIMINATOR table using PaymentDiscriminatorPOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class PaymentDiscriminatorModel {

	private static Logger log = Logger
			.getLogger(PaymentDiscriminatorModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * Adds Payment
	 * 
	 * @param pojo
	 * @return
	 */

	public long add(PaymentDiscriminatorPOJO pojo) {
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
	 * Updates Payment
	 * 
	 * @param pojo
	 * @return
	 */

	public void update(PaymentDiscriminatorPOJO pojo) {
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
	 * Deletes Payment
	 * 
	 * @param pojo
	 * @return
	 */

	public void delete(PaymentDiscriminatorPOJO pojo) {
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
	 * Finds Payment by its primary key.
	 * 
	 * @param pojo
	 * @return
	 */

	public PaymentDiscriminatorPOJO findByPK(long pk) {
		log.debug("Model findByPK Started");
		Session session = null;
		PaymentDiscriminatorPOJO pojo = null;
		try {
			session = factory.openSession();
			pojo = (PaymentDiscriminatorPOJO) session.get(
					PaymentDiscriminatorPOJO.class, pk);
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return pojo;
	}

}
