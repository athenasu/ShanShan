package tw.idv.tibame.tfa104.shanshan.web.cabinVacancy.entity;

import java.io.Serializable;
import java.sql.Date;

public class CabinVacancyVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer cabin_id;
	private Date date;
	private Integer cabin_vacancy;
	private Date update_time;
	
	
	public Integer getCabin_id() {
		return cabin_id;
	}
	public void setCabin_id(Integer cabin_id) {
		this.cabin_id = cabin_id;
	}
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getCabin_vacancy() {
		return cabin_vacancy;
	}
	public void setCabin_vacancy(Integer cabin_vacancy) {
		this.cabin_vacancy = cabin_vacancy;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	

}
