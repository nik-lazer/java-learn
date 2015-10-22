package lan.training.hibernate.dao;

import lan.training.core.dao.CrudDao;
import lan.training.core.model.IEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nik-lazer on 18.10.15.
 */
public abstract class AbstractHibernateDao<T extends IEntity> implements CrudDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@Transactional
	public void add(T model) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(model);
	}

	@Override
	@Transactional
	public void update(Integer id, T model) {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		T model = getById(id);
		if (model != null) {
			sessionFactory.getCurrentSession().delete(model);
		}

	}
}
