package tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.entity.MtnCabinCombineVO;

public interface MtnCabinCombineDAO_interface {

	
	public void insert(MtnCabinCombineVO MtnCabinCombineVO);
    public void update(MtnCabinCombineVO MtnCabinCombineVO);
    public void delete(Integer combine_id);
	public MtnCabinCombineVO findByPK(Integer combine_id);
    public List<MtnCabinCombineVO> getAll();
}
