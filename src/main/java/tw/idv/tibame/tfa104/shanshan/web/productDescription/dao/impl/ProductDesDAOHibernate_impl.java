package tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;

@Repository
public class ProductDesDAOHibernate_impl implements ProductDesDAOHibernate {

	@Autowired
	private SessionFactory sessionFactory;
	//參考	List<Object[]> wishlistArticles = (List<Object[]>) session.createSQLQuery
	//Query<Product> query = session.createQuery("FROM Product WHERE productId = :id", Product.class)
	//HQL syntax 確認回傳的是product物件可對應到前面的Query<Product>
	//.setParameter("id",productId);
	
	@Override
	public List<FindByProductIdBO> findByProductId(Integer productId){
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> product //remember add "as" column
				= session.createNativeQuery("select p.product_id as productId,"
				+ "d.product_des_id as prodesId,p.product_name as productName,"
				+ "d.product_size as productSize,d.product_color as productColor,"
				+ "d.product_price as productPrice,d.product_stock as proDesStock,"
				+ "img.product_img as productImg,d.status as status,"
				+ "p.product_intro as productIntro "
				+ "from ShanShan.product p "
				+ "JOIN product_description as d on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
				+ "WHERE d.status = 1 and p.product_id = :id", FindByProductIdBO.class)
				.setParameter("id",productId)
				.list();
		return product;
	}

	@Override
	public List<FindByProductIdBO> findByPK(Integer prodesId) {
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> prodes 
				= session.createNativeQuery("select d.product_des_id as prodesId,"
				+ "p.product_id as productId, p.product_name as productName,"
				+ "d.product_size as productSize, d.product_stock as proDesStock,"
				+ "d.product_color as productColor,d.product_price as productPrice,"
				+ "i.product_img as productImg,d.status as status,"
				+ "p.product_intro as productIntro "
				+ "from ShanShan.product_description as d "
				+ "JOIN product as p on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id " 
				+ "WHERE d.status = 1 and d.product_des_id = :id", FindByProductIdBO.class)
				.setParameter("id", prodesId)
				.list();
		return prodes;
	}

	@Override
	public List <FindByProductIdBO> findByStock(Integer prodesStock) {
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> stock
				= session.createNativeQuery("select d.product_des_id as prodesId,"
				+ "p.product_id as productId, p.product_name as productName,"
				+ "d.product_size as productSize, d.product_stock as proDesStock,"
				+ "d.product_color as productColor,d.product_price as productPrice," 
				+ "i.product_img as productImg,d.status as status,"
				+ "p.product_intro as productIntro "
				+ "from ShanShan.product_description as d " 
				+ "JOIN product as p on p.product_id = d.product_id " 
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
				+ "WHERE i.product_img_id =(select min(product_img_id) from product_img WHERE product_des_id = i.product_des_id "
				+ "group by product_des_id) and d.status = 1 "
				+ "and d.product_stock = :id", FindByProductIdBO.class)
				.setParameter("id", prodesStock)
				.list();
		return stock;
	}

	@Override
	public List<FindByProductIdBO> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> all
				= session.createNativeQuery("select d.product_des_id as prodesId,"
				+ "p.product_id as productId, p.product_name as productName,"
				+ "d.product_size as productSize, d.product_stock as proDesStock,"
				+ "d.product_color as productColor,d.product_price as productPrice,"
				+ "i.product_img as productImg,d.status as status,"
				+ "p.product_intro as productIntro "
				+ "from ShanShan.product_description as d "
				+ "JOIN product as p on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id " 
				+ "WHERE d.status = 1 ", FindByProductIdBO.class)
				.list();
		return all;
	}

	
	@Override
	public Integer updateProdesStock(Integer prodesId, Integer prodesStock) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("UPDATE ProductDesVO set "
				+ "productStock = productStock - :prodesStock "
				+ "WHERE productDesId =:prodesId")
				.setParameter("prodesStock", prodesStock)
				.setParameter("prodesId", prodesId)
				.executeUpdate();
		
	}
	
}
