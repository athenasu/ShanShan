package tw.idv.tibame.tfa104.shanshan;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.impl.ArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;

public class XXXTest {
	
	public static void main(String[] args) {
		ArticleDAO articleDao = new ArticleDAO();
		List<ArticleVO> articles = articleDao.findByMemIdGiveAll(1);
		for (ArticleVO article : articles) {
			System.out.println(article.getMountain_longitude());
			System.out.println(article.getMountain_latitude());
		}
	}
}
