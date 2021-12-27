package tw.idv.tibame.tfa104.shanshan.web.company.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.company.dao.CompanyDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;

@Repository
public class CompanyDAOHibernate_impl implements CompanyDAOHibernate {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public CompanyVO findByPK(Integer companyId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(CompanyVO.class,companyId);
	}
	
	
//	@SuppressWarnings("unchecked")
	@Override
	//得到所有店家資訊
	public List<CompanyVO> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CompanyVO> criteriaQuery = criteriaBuilder.createQuery(CompanyVO.class);
		Root<CompanyVO>root = criteriaQuery.from(CompanyVO.class);
		criteriaQuery = criteriaQuery.select(root);
		Query<CompanyVO> query = session.createQuery(criteriaQuery);
		List<CompanyVO> list = query.list();
 		return list;
	}
	
	@Override
	public List<CompanyVO> findComByString(String search) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<CompanyVO> criteriaQuery = criteriaBuilder.createQuery(CompanyVO.class);
		Root<CompanyVO>root = criteriaQuery.from(CompanyVO.class);
		criteriaQuery.where(criteriaBuilder.like(root.get("companyName"), "%" + search + "%"));
//		criteriaQuery.multiselect(root.get("companyName"),root.get("companyIntro")); 為何需要建構子
		Query<CompanyVO> query = session.createQuery(criteriaQuery);
		List<CompanyVO> list = query.list();
		return list;
	}

	@Override
	public Integer register(CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		File file = new File(servletContext.getRealPath("/company/company_imgs/presetBanner.png"));
		byte[] bytefile = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			bytefile = new byte[fis.available()];
			fis.read(bytefile);
			fis.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
		company.setCompanyBanner(bytefile);
		System.out.println("add company success");
		
		return (Integer)session.save(company);
	}


	@Override
	public CompanyVO checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<CompanyVO> query = session.createQuery("FROM CompanyVO WHERE companyEmail = :email",CompanyVO.class)
													.setParameter("email", email);
		return query.uniqueResult();
	}

	@Override
	public Integer updateStatus(Integer companyId,Integer companyStatus) {
		Session session = sessionFactory.getCurrentSession();
		CompanyVO tempcompany = session.get(CompanyVO.class,1);
		if(tempcompany.getCompanyStatus() != null ){
			tempcompany.setCompanyStatus(companyStatus);
		}
		return 1;
	}
	@Override
	public CompanyVO update(byte[] file, CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		CompanyVO testcompany = session.get(CompanyVO.class,1);//companyId先用1測試
		if(testcompany.getCompanyName() != null && testcompany.getCompanyName() != "") {
			testcompany.setCompanyName(company.getCompanyName());
		}
		if(testcompany.getCompanyPassword() != null && testcompany.getCompanyPassword() != "") {
			testcompany.setCompanyPassword(company.getCompanyPassword());
		}
		if(testcompany.getCompanyOwner() != null && testcompany.getCompanyOwner() != "") {
			testcompany.setCompanyOwner(company.getCompanyOwner());
		}
		if(testcompany.getCompanyAddress() != null && testcompany.getCompanyAddress()!= "") {
			testcompany.setCompanyAddress(company.getCompanyAddress());
		}
		if(testcompany.getCompanyPhone() != null && testcompany.getCompanyPhone() != "") {
			testcompany.setCompanyPhone(company.getCompanyPhone());
		}
		if(testcompany.getCompanyCell() != null && testcompany.getCompanyCell() != "") {
			testcompany.setCompanyCell(company.getCompanyCell());
		}
		if(testcompany.getCompanyIntro() != null && testcompany.getCompanyIntro() != "") {
			testcompany.setCompanyIntro(company.getCompanyIntro());
		}
		if(testcompany.getCompanyBanner() != null) {
			testcompany.setCompanyBanner(file);
		}
		if(testcompany.getCompanyBanner() == null) {
			testcompany.setCompanyBanner(file);
		}
		return testcompany;
	}


	@Override
	public CompanyVO checkLogin(CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CompanyVO> cq = cb.createQuery(CompanyVO.class);
		Root<CompanyVO> root = cq.from(CompanyVO.class);
		Predicate checkEmail = cb.equal(root.get("companyEmail"), company.getCompanyEmail());
		Predicate checkPW = cb.equal(root.get("companyPassword"), company.getCompanyPassword());
		Predicate check = cb.and(checkEmail,checkPW);
		cq = cq.where(check);
		Query<CompanyVO> query = session.createQuery(cq);
		CompanyVO companyLoggedIn = query.uniqueResult();
		return companyLoggedIn;
	}
	
	@Override
	public CompanyVO checkStatus(CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CompanyVO> cq = cb.createQuery(CompanyVO.class);
		Root<CompanyVO> root = cq.from(CompanyVO.class);
		Predicate checkEmail = cb.equal(root.get("companyEmail"), company.getCompanyEmail());
		Predicate checkStatus = cb.equal(root.get("companyStatus"), company.getCompanyStatus());
		Predicate check = cb.and(checkEmail,checkStatus);
		cq = cq.where(check);
		Query<CompanyVO> query = session.createQuery(cq);
		CompanyVO companyStatus = query.uniqueResult();
		return companyStatus;
	}


	@Override
	public CompanyVO updateCompanyPwd(Integer companyId, String companyPassword) {
		Session session = sessionFactory.getCurrentSession();
		CompanyVO company = session.get(CompanyVO.class, companyId);
		company.setCompanyPassword(companyPassword);
		return company;
	}





	



	
	

}
