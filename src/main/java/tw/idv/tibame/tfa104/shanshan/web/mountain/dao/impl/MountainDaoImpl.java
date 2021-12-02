package tw.idv.tibame.tfa104.shanshan.web.mountain.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.mountain.dao.MountainDao;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;

@Repository
public class MountainDaoImpl implements MountainDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Mountain findMtnByPk(Integer mtnId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Mountain.class, mtnId);
	}

	@Override
	public List<Mountain> findAllMtns() {
		Session session = sessionFactory.getCurrentSession();
		Query<Mountain> mountains = session.createQuery("FROM Mountain", Mountain.class);
		List<Mountain> mountainList = mountains.getResultList();
		return mountainList;
	}
	
	

}
