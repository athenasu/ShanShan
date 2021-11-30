package tw.idv.tibame.tfa104.shanshan.web.productImg.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgBODAO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.impl.ProductImgBODAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgBO;


public class ProductImgBOServiceImpl implements ProductImgBOService{

	ProductImgBODAO dao = new ProductImgBODAOImpl();

//	查詢特定商品明細編號的第1/2/3/4/5張圖片 變數為product_des_i = ? / limit = ? ,1 (0是第1張圖片, 1是第二章圖片以此類推)
    @Override
	public ProductImgBO getPic(Integer product_des_id, Integer ingore_num_pic) {
		return dao.getPic(product_des_id, ingore_num_pic);
	}

//	查詢特定商品編號的第一個商品明細編號的第一張圖片
	@Override
	public ProductImgBO getProDesFirstPic(Integer product_id) {
		return dao.getProDesFirstPic(product_id);
	}

//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProPic() {
		return null;
	}

//	查詢特定商品編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProDesPic() {
		return null;
	}



	

}
