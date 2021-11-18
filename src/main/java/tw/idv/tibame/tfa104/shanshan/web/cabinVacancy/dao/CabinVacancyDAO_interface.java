package tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.entity.CabinVacancyVO;


public interface CabinVacancyDAO_interface {
	
     public void update(CabinVacancyVO CabinVacancyVO);
     public CabinVacancyVO findByPrimaryKey(Integer cabin_id);

}
