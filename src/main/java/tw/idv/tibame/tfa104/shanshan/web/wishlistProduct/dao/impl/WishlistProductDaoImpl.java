package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.dao.WishlistProductDao;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProductBO;

@Repository
public class WishlistProductDaoImpl implements WishlistProductDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public List<WishlistProductBO> findWishlistProductsByMemberId(Integer memberId){
		Session session = sessionFactory.getCurrentSession();
		 List<WishlistProductBO> wishlistProducts = session.createNativeQuery(
				 "select " + 
					 "wp.wishlist_product_id as wishlistProductId, " + 
					 "p.product_id as productId, " + 
					 "p.product_name as productName, " + 
					 "i.product_img as productImg, " + 
					 "c.company_name as companyName, " + 
					 "c.company_banner as companyBanner " + 
				 "from " + 
				 	"wishlist_product wp " + 
				 "join product p " + 
				 	"on wp.product_id = p.product_id " + 
				 "join product_description pd " + 
				 	"on p.product_id = pd.product_id " + 
				 "join product_img i " + 
				 	"on i.product_des_id = pd.product_des_id " + 
				 "join company c " + 
				 	"on p.company_id = c.company_id " + 
				 "where " + 
				 	"i.product_img_id =( " + 
						 "select min(product_img_id) " + 
						 "from product_img " + 
						 "where product_des_id = i.product_des_id " + 
						 "group by product_des_id) " + 
					"and " + 
						"wp.member_id = :id " +
				  "order by wp.wishlist_product_id desc", WishlistProductBO.class)
				 .setParameter("id", memberId)
				 .list();
		
		return wishlistProducts;
	}
	
	@Override
	public Integer deleteWishlistProductMemIdProductId(Integer memberId, Integer productId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(
				"DELETE WishlistProduct " +
				"WHERE memberId = :memberId AND productId = :productId")
				.setParameter("memberId", memberId)
				.setParameter("productId", productId)
				.executeUpdate();
	}

	@Override
	public Integer deleteWishlistProduct(WishlistProduct wishlistProduct) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(wishlistProduct);
		return 1;
	}
	
	@Override
	public Integer addWishlistProduct(WishlistProduct wishlistProduct) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(wishlistProduct); // returns an id
	}
}
