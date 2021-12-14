package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "points_used_act")
public class PointsUsedArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "points_used_act_id")
	private Integer pointsUsedActId;
	@Column(name = "member_id")
	private Integer memberId;
	@Column(name = "article_id")
	private Integer articleId;
	@Column(name = "points_used")
	private Integer pointsUsed;
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "points_used_date")
	private Date pointsUsedDate;

	public Integer getPointsUsedActId() {
		return pointsUsedActId;
	}

	public void setPointsUsedActId(Integer pointsUsedActId) {
		this.pointsUsedActId = pointsUsedActId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getPointsUsed() {
		return pointsUsed;
	}

	public void setPointsUsed(Integer pointsUsed) {
		this.pointsUsed = pointsUsed;
	}

	public Date getPointsUsedDate() {
		return pointsUsedDate;
	}

	public void setPointsUsedDate(Date pointsUsedDate) {
		this.pointsUsedDate = pointsUsedDate;
	}

}
