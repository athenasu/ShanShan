package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class PopularEventsMountainBO extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mountainId")
	private Integer mountainId;
	
	@Column(name = "mountainDistrict")
	private Integer mountainDistrict;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "mountainPic")
	private byte[] mountainPic;

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
	}

	public Integer getMountainDistrict() {
		return mountainDistrict;
	}

	public void setMountainDistrict(Integer mountainDistrict) {
		this.mountainDistrict = mountainDistrict;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PopularEventsMountainBO [mountainId=" + mountainId + ", mountainDistrict=" + mountainDistrict
				+ ", mountainName=" + mountainName + ", mountainPic=" + Arrays.toString(mountainPic) + "]";
	}

}
