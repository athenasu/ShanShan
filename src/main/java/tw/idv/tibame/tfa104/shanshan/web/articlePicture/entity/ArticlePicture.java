package tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article_picture")
public class ArticlePicture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer article_picture_id;
	private Integer article_id;

	@Column(name = "article_picture", columnDefinition = "LONGBLOB")
	private Byte[] article_picture;

	public Integer getArticle_picture_id() {
		return article_picture_id;
	}

	public void setArticle_picture_id(Integer article_picture_id) {
		this.article_picture_id = article_picture_id;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Byte[] getArticle_picture() {
		return article_picture;
	}

	public void setArticle_picture(Byte[] article_picture) {
		this.article_picture = article_picture;
	}

}
