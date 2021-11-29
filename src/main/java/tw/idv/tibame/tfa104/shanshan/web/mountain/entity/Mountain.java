package tw.idv.tibame.tfa104.shanshan.web.mountain.entity;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mountain")
public class Mountain implements Serializable {

 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "mountain_id")
 private Integer mountainId;
 @Column(name = "mountain_district")
 private Integer moutainDistrict;
 @Column(name = "mountain_name")
 private String mountainName;
 @Column(name = "mountain_longitude")
 private BigDecimal mountainLongitude;
 @Column(name = "mountain_latitude")
 private BigDecimal mountainLatitude;
 @Column(name = "mountain_pic", columnDefinition = "LONGBLOB")
 private Byte[] mountainPic;
 @Column(name = "mountain_info")
 private String mountainInfo;


 public Integer getMountainId() {
  return mountainId;
 }

 public void setMountainId(Integer mountainId) {
  this.mountainId = mountainId;
 }

 public Integer getMoutainDistrict() {
  return moutainDistrict;
 }

 public void setMoutainDistrict(Integer moutainDistrict) {
  this.moutainDistrict = moutainDistrict;
 }

 public String getMountainName() {
  return mountainName;
 }

 public void setMountainName(String mountainName) {
  this.mountainName = mountainName;
 }

 public BigDecimal getMountainLongitude() {
  return mountainLongitude;
 }

 public void setMountainLongitude(BigDecimal mountainLongitude) {
  this.mountainLongitude = mountainLongitude;
 }

 public BigDecimal getMountainLatitude() {
  return mountainLatitude;
 }

 public void setMountainLatitude(BigDecimal mountainLatitude) {
  this.mountainLatitude = mountainLatitude;
 }

 public Byte[] getMountainPic() {
  return mountainPic;
 }

 public void setMountainPic(Byte[] mountainPic) {
  this.mountainPic = mountainPic;
 }

 public String getMountainInfo() {
  return mountainInfo;
 }

 public void setMountainInfo(String mountainInfo) {
  this.mountainInfo = mountainInfo;
 }

}