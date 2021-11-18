package tw.idv.tibame.tfa104.shanshan.web.cabin.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.cabin.entity.CabinVO;


public interface CabinDAO_interface {

     public CabinVO findByPrimaryKey(Integer cabin_id);
     public CabinVO findByMtn(Integer mountain_id);

}
