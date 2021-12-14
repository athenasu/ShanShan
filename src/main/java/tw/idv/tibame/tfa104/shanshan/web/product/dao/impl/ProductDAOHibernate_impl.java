package tw.idv.tibame.tfa104.shanshan.web.product.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.product.dao.ProductDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

@Repository
public class ProductDAOHibernate_impl implements ProductDAOHibernate {

	@Autowired //spring 注入物件可使用
	private SessionFactory sessionFactory;
	
	@Override
	public Product addproduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		return product;
	}
	@Override
	public List<ProductBO> findById(Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		List <ProductBO> proid
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 1 " 
						+ "and p.product_id = :id",ProductBO.class)
						.setParameter("id", productId)
						.list();
		return proid;
		
	}
	
	@Override
	public List<ProductBO> findNew() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductBO> newpro 
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 1 " 
						+ "order by p.product_id desc limit 10",ProductBO.class)
						.list();
		return newpro;
	}
	
	@Override
	public List<ProductBO> findByCompanyName(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<ProductBO> compro 
				=  session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 1 " 
						+ "and c.company_name like :name",ProductBO.class)
						.setParameter("name","%" + search + "%")
						.list();
		return compro;
	}

	@Override
	public List<ProductBO> findProdNameByString(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<ProductBO> prodname 
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 1 " 
						+ "and p.product_name like :name",ProductBO.class)
						.setParameter("name","%" + search + "%")
						.list();
		return prodname;
	}

	@Override
	public List<ProductBO> findByType(Integer typeId) {
		Session session = sessionFactory.getCurrentSession();
		List <ProductBO> type
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 0 " 
						+ "and p.product_type = :id",ProductBO.class)
						.setParameter("id",typeId)
						.list();
		return type;
	}

	@Override
	public List<ProductBO> findByCompanyId(Integer companyId) {
		Session session = sessionFactory.getCurrentSession();
		List <ProductBO> comId
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 1 " 
						+ "and c.company_id = :id",ProductBO.class)
						.setParameter("id",companyId)
						.list();
		return comId;
	}

	@Override
	public List<ProductBO> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<ProductBO> allpro
				= session.createNativeQuery("select p.product_id as productId,d.product_des_id as prodesId,"
						+ "c.company_name as companyName,p.product_name as productName,"
						+ "c.company_id as companyId,c.company_intro as companyIntro,"
						+ "p.product_type as productType,d.product_size as productSize,"
						+ "d.product_color as productColor,d.product_stock as proDesStock,"
						+ "p.product_intro as productIntro,d.status as status,"
						+ "p.product_price as productPrice,i.product_img as productImg "
						+ "from ShanShan.product as p " 
						+ "JOIN company as c on c.company_id = p.company_id "
						+ "JOIN product_description as d on d.product_id = p.product_id " 
						+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
						+ "WHERE i.product_img_id =(select min(product_img_id)"
						+ "from product_img WHERE product_des_id = i.product_des_id "
						+ "group by product_des_id)"
						+ "and p.status = 0 " ,ProductBO.class)
						.list();
		return allpro;
	}

	
	
	

}
