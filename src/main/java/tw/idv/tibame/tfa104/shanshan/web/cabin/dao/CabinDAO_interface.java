package tw.idv.tibame.tfa104.shanshan.web.cabin.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.cabin.entity.CabinVO;


public interface CabinDAO_interface {

 
     public void insertCabin(CabinVO CabinVO);
     public void updateCabin(CabinVO CabinVO);
     public void deleteCabin(Integer cabin_id);
     public List<CabinVO> getAllCabin();
     public CabinVO findByCabinId(Integer cabin_id);

     
}
