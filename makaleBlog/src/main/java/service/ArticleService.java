package service;

import java.util.List;

import org.springframework.stereotype.Component;

import entity.Article;
@Component
public interface ArticleService {
	public String create(Article article);
	public List<Article> getAllArticles();
	public List<Article> getMainPageAllArticles();
    public void deleteArticle(int articleId);
    public Article getSingleArticle(int articleId);
    public void articleUpdate(Article article);


}
