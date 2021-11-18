package tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity;

import java.io.Serializable;

public class ArticlePictureVO implements Serializable{
	private Integer article_picture_id;
	private Integer article_id;
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

