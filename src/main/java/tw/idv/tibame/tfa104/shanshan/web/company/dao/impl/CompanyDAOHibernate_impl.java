package tw.idv.tibame.tfa104.shanshan.web.company.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		Query<CompanyVO> query = session.createQuery(criteriaQuery);
		List<CompanyVO> list = query.list();
//		List <CompanyVO> companyAll = session .createSQLQuery("select company_id,company_name,company_email,"
//															+ "company_phone,company_cell,company_banner,"
//															+ "company_intro,company_address "
//															+ "FROM company;")
//															.list();
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
	public Integer register(byte[] file, CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		File file2 = new File("/src/main/webapp/company/company_imgs/presetBanner");
		byte[] bytefile = null;
		try {
			FileInputStream fis = new FileInputStream(file2);
			bytefile = new byte[fis.available()];
			fis.read(bytefile);
			fis.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
		
		company.setCompanyBanner(bytefile);
		session.save(company);
		System.out.println("add success");
		return 1;
	}


	@Override
	public boolean checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<CompanyVO> query = session.createQuery("FROM company WHERE companyEmail = :email",CompanyVO.class)
													.setParameter("email", email);
		return query.uniqueResult() != null;
	}


	@Override
	public CompanyVO update(byte[] file, CompanyVO company) {
		Session session = sessionFactory.getCurrentSession();
		CompanyVO testcompany = session.get(CompanyVO.class, 8);
		if(testcompany.getCompanyPassword() != null && testcompany.getCompanyPassword() != "") {
			testcompany.setCompanyPassword(company.getCompanyPassword());
		}
		if(testcompany.getCompanyOwner() != null && testcompany.getCompanyOwner() != "") {
			testcompany.setCompanyOwner(company.getCompanyOwner());
		}
		if(testcompany.getCompanyName() != null && testcompany.getCompanyName() != "") {
			testcompany.setCompanyName(company.getCompanyName());
		}
		if(testcompany.getCompanyAddress() != null && testcompany.getCompanyAddress() != "") {
			testcompany.setCompanyAddress(company.getCompanyAddress());
		}
		if(testcompany.getCompanyPhone() != null && testcompany.getCompanyPhone() != "") {
			testcompany.setCompanyPhone(company.getCompanyPhone());
		}
		if(testcompany.getCompanyCell() != null && testcompany.getCompanyCell() != "") {
			testcompany.setCompanyCell(company.getCompanyCell());
		}
		if(testcompany.getCompanyIntro() != null && testcompany.getCompanyIntro()!= "") {
			testcompany.setCompanyIntro(company.getCompanyIntro());
		}
//		如果沒有給新圖就會更新失敗?
		if(testcompany.getCompanyBanner() != null) {
			testcompany.setCompanyBanner(file);
		}
		if(testcompany.getCompanyBanner() == null) {
			testcompany.setCompanyBanner(file);
		}
		
		return testcompany;
	}



	
	

}
