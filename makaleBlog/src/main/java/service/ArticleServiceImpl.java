package service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dao.ArticleFacade;
import dao.Test;
import entity.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleFacade articleFacade;
	@Autowired
	private Test test;

	@Override
	public String create(Article article) {
		String message = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		article.setAuthorName(name);
		boolean cretiaonResult = articleFacade.create(article);
		if (cretiaonResult) {
			message = "Makale Baþarý ile Eklendi!";
		} else {
			message = "Makale Eklenmesi Sýrasýnda Hata Meydana Geldi!";
		}
		return message;

	}

	@Override
	public List<Article> getMainPageAllArticles() {
		return articleFacade.getAllRecords("Article.findAll");

	}

	@Override
	public void deleteArticle(int articleId) {

		articleFacade.delete(articleId);
	}

	@Override
	public List<Article> getAllArticles() {
		return articleFacade.getAllRecords("Article.findAll");
	}

	@Override
	public Article getSingleArticle(int articleId) {

		return articleFacade.ArticleSingle(articleId);
	}

	@Override
	public void articleUpdate(Article article) {

		articleFacade.update(article);
	}

}
