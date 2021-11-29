package tw.idv.tibame.tfa104.shanshan.web.cabin.entity;

import java.io.Serializable;

public class CabinVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer cabin_id;
	private String cabin_name;
	private byte[] cabin_pic;
	
	public Integer getCabin_id() {
		return cabin_id;
	}
	public void setCabin_id(Integer cabin_id) {
		this.cabin_id = cabin_id;
	}

	public String getCabin_name() {
		return cabin_name;
	}
	public void setCabin_name(String cabin_name) {
		this.cabin_name = cabin_name;
	}
	public byte[] getCabin_pic() {
		return cabin_pic;
	}
	public void setCabin_pic(byte[] cabin_pic) {
		this.cabin_pic = cabin_pic;
	}
	

	
}
