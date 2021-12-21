package tw.idv.tibame.tfa104.shanshan.web.productImg.dao;

import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

public interface ProductImgDAO_interface {
	public ProductImgVO addProImg(ProductImgVO productImgVO);
	public void update(ProductImgVO productImgVO);
	public void delete (int productImgId);//用照片ID來刪除照片資料
	
	
}
