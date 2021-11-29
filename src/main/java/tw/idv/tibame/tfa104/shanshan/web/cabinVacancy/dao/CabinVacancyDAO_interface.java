package tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.entity.CabinVacancyVO;


public interface CabinVacancyDAO_interface {
	
	 public void insertCabinVacancy(CabinVacancyVO CabinVacancyVO);
     public void update(CabinVacancyVO CabinVacancyVO);
     public void deleteCabinVacancy(Integer cabin_id);

     public CabinVacancyVO findByCabin(Integer cabin_id);
     public List<CabinVacancyVO> getAllCabinVacancy();

}
