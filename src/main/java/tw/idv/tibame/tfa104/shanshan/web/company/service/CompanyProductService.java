package tw.idv.tibame.tfa104.shanshan.web.company.service;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

public interface CompanyProductService {
	
	//單一店家更新商品上下架狀態
    public Core updateProDesStatusOfShelf(Integer prodesStatus, Integer prodesId, Core core);

    //店家新增商品
    public Integer addProduct(Product product,ProductDesVO productdesVO);
    
    
}
