package tw.idv.tibame.tfa104.shanshan.web.admin.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.admin.dao.AdminDAO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;


@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SessionFactory sessionFactory;
	

}
