package in.co.sunrays.hibernate.model;

import in.co.sunrays.hibernate.pojo.rel.EmployeePOJO;
import in.co.sunrays.hibernate.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * Contains service methods of Employee Detached Criteria. Manipulate
 * ST_EMPLOYEE table using EmployeePOJO
 *
 * @version 1.0
 * @since 16 Nov 2014
 * @author SUNRAYS Developer
 * @Copyright (c) sunRays Technologies. All rights reserved.
 * @URL www.sunrays.co.in
 */

public class EmployeeDetachedCriteriaModel {

	private static Logger log = Logger
			.getLogger(EmployeeDetachedCriteriaModel.class);

	SessionFactory factory = HibernateUtil.getSessionFactory();

	/**
	 * List an Employee
	 * 
	 * @return
	 */

	public List list() {

		log.debug("Model list Started");
		Session session = null;
		List list = null;
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(EmployeePOJO.class);
			session = factory.openSession();
			Criteria executableCriteria = detachedCriteria
					.getExecutableCriteria(session);
			list = executableCriteria.list();
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

	/**
	 * searches Employee as per give parameters
	 * 
	 * @param pojo
	 * @return
	 */

	public List search(EmployeePOJO pojo) {
		log.debug("Model search Started");
		Session session = null;
		List list = null;
		try {
			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(EmployeePOJO.class);
			session = factory.openSession();
			if (pojo.getId() > 0) {
				detachedCriteria.add(Restrictions.eq("id", pojo.getId()));
			}
			if (pojo.getFirstName() != null && pojo.getFirstName().length() > 0) {
				detachedCriteria.add(Restrictions.like("firstName",
						pojo.getFirstName() + "%"));
			}
			if (pojo.getLastName() != null && pojo.getLastName().length() > 0) {
				detachedCriteria.add(Restrictions.like("lastName",
						pojo.getLastName() + "%"));
			}
			Criteria executableCriteria = detachedCriteria
					.getExecutableCriteria(session);
			list = executableCriteria.list();
			System.out.println("size" + list.size());
		} catch (HibernateException e) {
			log.error("Database Exception..", e);
		} finally {
			session.close();
		}
		log.debug("Model findByPK End");
		return list;
	}

}
