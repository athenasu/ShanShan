package tw.idv.tibame.tfa104.shanshan.web.company.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

public interface CompanyProductService {
	//單一店家商品列表
	List<ProductBO> findByCompanyId(Integer companyId);
	//單一店家更新商品上下架狀態
    public Core updateProDesStatusOfShelf(Integer prodesStatus, Integer prodesId, Core core);
    //=========================================================
    //商品新增step1
    public Integer addProduct(Product product);
    //商品新增明細step2
    public Integer addProdes(ProductDesVO productdesVO);
    //商品新增照片step3
    public ProductImgVO addProImg(ProductImgVO productImgVO);
    //==========================================================
    
	//用ProductDesId搜尋 得到相關資訊
	List <FindByProductIdBO> findByPK(Integer prodesId);
	
	//得到商品圖
	public List<ProductImgVO> findByproDes(Integer productDesId);
	
	
}
