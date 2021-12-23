package tw.idv.tibame.tfa104.shanshan.web.productImg.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

public interface ProductImgDAO_interface {
	public ProductImgVO addProImg(ProductImgVO productImgVO);
	public Integer update(ProductImgVO productImgVO);
	public Integer delete (Integer productImgId);//用照片ID來刪除照片資料
	public List<ProductImgVO> findByproDes(Integer productDesId);

	
	
	
}
