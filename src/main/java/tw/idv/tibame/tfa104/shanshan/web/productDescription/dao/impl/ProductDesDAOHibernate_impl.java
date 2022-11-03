package tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;

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
				+ "from product p "
				+ "JOIN product_description as d on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id "
				+ "WHERE d.status = 1 and p.product_id = :id", FindByProductIdBO.class)
				.setParameter("id",productId)
				.list();
		return product;
	}

	@Override
	//單一商品全部資訊
	public List<FindByProductIdBO> findByPK(Integer prodesId) {
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> prodes 
				= session.createNativeQuery("select d.product_des_id as prodesId,"
				+ "p.product_id as productId, p.product_name as productName,"
				+ "d.product_size as productSize, d.product_stock as proDesStock,"
				+ "d.product_color as productColor,d.product_price as productPrice,"
				+ "i.product_img as productImg,d.status as status,"
				+ "p.product_intro as productIntro,"
				+ "i.product_img_id as productImgId,"
				+ "p.product_type as productType "
				+ "from product_description as d "
				+ "JOIN product as p on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id " 
				+ "WHERE d.status = 1 and d.product_des_id = :id", FindByProductIdBO.class)
				.setParameter("id", prodesId)
				.list();
		return prodes;
	}
	
	//單一商品資訊lulu用 不設定上下架狀態
	@Override
	public List<FindByProductIdBO> findByDesId(Integer prodesId) {
		Session session = sessionFactory.getCurrentSession();
		List <FindByProductIdBO> prodes 
			= session.createNativeQuery("select d.product_des_id as prodesId,"
			+ "p.product_id as productId, p.product_name as productName,"
			+ "d.product_size as productSize, d.product_stock as proDesStock,"
			+ "d.product_color as productColor,d.product_price as productPrice,"
			+ "i.product_img as productImg,d.status as status,"
			+ "p.product_intro as productIntro,"
			+ "i.product_img_id as productImgId,"
			+ "p.product_type as productType "
			+ "from product_description as d "
			+ "JOIN product as p on p.product_id = d.product_id "
			+ "JOIN product_img as i on i.product_des_id = d.product_des_id " 
			+ "WHERE d.product_des_id = :id", FindByProductIdBO.class)
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
				+ "from product_description as d " 
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
				+ "from product_description as d "
				+ "JOIN product as p on p.product_id = d.product_id "
				+ "JOIN product_img as i on i.product_des_id = d.product_des_id " 
				+ "WHERE d.status = 1 ", FindByProductIdBO.class)
				.list();
		return all;
	}

	
	@Override
	public Integer updateProdesStock(Integer prodesId, Integer prodesStock) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("UPDATE ProductDesVO SET "
				+ "productStock = productStock - :prodesStock "
				+ "WHERE productDesId =:prodesId")
				.setParameter("prodesStock", prodesStock)
				.setParameter("prodesId", prodesId)
				.executeUpdate();
		
	}

	@Override
	public Integer updateProDesStatusOfShelf(Integer prodesStatus, Integer prodesId) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("UPDATE ProductDesVO SET "
				+ " status =:prodesStatus WHERE  productDesId =:prodesId")
				.setParameter("prodesStatus", prodesStatus)
				.setParameter("prodesId", prodesId)
				.executeUpdate();
		return 1 ;
	}

	@Override
	public Integer addProdes(ProductDesVO productdesVO) {
		Session session = sessionFactory.getCurrentSession();
//		int result = session.createQuery("INSERT INTO ProductDesVO "
//				+ " (productId, productSize, productColor, productStock, productPrice)"  
//				+ "SELECT :productId, :productSize, :productColor, :productStock, :productPrice);")
//				.setParameter("productId",productId)
//				.setParameter("productSize", productdesVO.getProductSize())
//				.setParameter("productColor", productdesVO.getProductColor())
//				.setParameter("productStock", productdesVO.getProductStock())
//				.setParameter("productPrice", productdesVO.getProductPrice())
//				.executeUpdate();
		return (Integer)session.save(productdesVO);
		 
	}

	@Override
	public Integer updateProdes(ProductDesVO productdesVO) {
		Session session = sessionFactory.getCurrentSession();
		ProductDesVO tempProDes = session.get(ProductDesVO.class,productdesVO.getProductDesId());
		if(tempProDes.getProductSize() != null) {
			tempProDes.setProductSize(productdesVO.getProductSize());
		}
		if(tempProDes.getProductColor() != null &&tempProDes.getProductColor() != "" ) {
			tempProDes.setProductColor(productdesVO.getProductColor());
		}
		if(tempProDes.getProductStock() != null) {
			tempProDes.setProductStock(productdesVO.getProductStock());
		}
		if(tempProDes.getProductPrice() != null) {
			tempProDes.setProductPrice(productdesVO.getProductPrice());
		}
		return tempProDes.getProductDesId();
	}


	
}
