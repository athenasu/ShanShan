package tw.idv.tibame.tfa104.shanshan.web.mtnCabinCombine.entity;

import java.io.Serializable;

public class MtnCabinCombineVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer combine_id;
	private Integer mountain_id;
	private Integer cabin_id;
	public Integer getCombine_id() {
		return combine_id;
	}
	public void setCombine_id(Integer combine_id) {
		this.combine_id = combine_id;
	}
	public Integer getMountain_id() {
		return mountain_id;
	}
	public void setMountain_id(Integer mountain_id) {
		this.mountain_id = mountain_id;
	}
	public Integer getCabin_id() {
		return cabin_id;
	}
	public void setCabin_id(Integer cabin_id) {
		this.cabin_id = cabin_id;
	}
	
}
