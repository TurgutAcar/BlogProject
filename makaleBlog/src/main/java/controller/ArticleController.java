package controller;

import java.util.List;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ArticleDao;
import dao.Test;
import entity.Article;
import service.ArticleService;
import validator.ArticleFormValidator;

@Controller

public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private Test test;

	@Autowired
	private PostArticleController postArticleController;

	@Autowired
	private ArticleFormValidator articleFormValidator;

	@RequestMapping(value = "/")
	public String getAnaSayfa(ModelMap modelMap) {
		modelMap.addAttribute("articleList", articleService.getMainPageAllArticles());

		return "index";

	}

	@RequestMapping(value = "/index")
	public String getAnaSayfam(ModelMap modelMap) {
		modelMap.addAttribute("articleList", articleService.getMainPageAllArticles());

		return "index";

	}

	@ModelAttribute("article")
	public Article getArticleObject() {
		return new Article();
	}

	@RequestMapping(value = "/articleAdd", method = RequestMethod.GET)
	public String addArticle() {
		return "articleAdd";
	}

	@RequestMapping(value = "/articleUpdate", method = RequestMethod.GET)
	public String uppArticle() {
		return "articleUpdate";
	}

	@RequestMapping(value = "/articleAdd", method = RequestMethod.POST)
	public String postArticle(@ModelAttribute("article") Article article, BindingResult result, ModelMap modelMap) {
		articleFormValidator.validate(article, result);
		String insertMessage = "";
		if (result.hasErrors()) {
			return "articleAdd";
		}
		try {

			// System.out.println("tarih3:"+article.getArticleDate());
			// article.setArticleId(5);
			insertMessage = articleService.create(article);

			// articleDao.createArticle(article);
			// testDAO.createArticle(article);

		} catch (DatabaseException e) {
			System.out.println("An error occured while inserting new user!");
			System.out.println("Error is:" + e);
		}
		modelMap.addAttribute("message", insertMessage);

		// postArticleController.setPostArticleMessage(insertMessage);

		return "postArticle";
	}

	@RequestMapping(value = "articleList", method = RequestMethod.GET)
	public String getArticleList(ModelMap modelMap) {
		modelMap.addAttribute("listArticle", articleService.getAllArticles());
		return "articleList";
	}

	@RequestMapping(value = "/articleDelete", method = RequestMethod.GET)
	public String deleteArticle(@ModelAttribute("articleId") int articleId) {
		// testDAO.delete(articleId);
		articleService.deleteArticle(articleId);

		return "redirect:/articleList";
	}

	@RequestMapping(value = "/articleView", method = RequestMethod.GET)
	public String articleView(@RequestParam("id") String id, ModelMap map) {
		List<Article> articles = articleService.getAllArticles();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == Integer.parseInt(id)) {
				map.addAttribute("article", articles.get(i));
			}
		}
		return "articleView";
	}

	@RequestMapping(value = "/articleGetSingle", method = RequestMethod.GET)
	public String articleGetSingle(@ModelAttribute("articleId") int articleId, ModelMap model) {
		Article article = articleService.getSingleArticle(articleId);
		model.addAttribute("article", article);

		return "/articleUp";
	}

	@RequestMapping(value = "/articleUpdate", method = RequestMethod.POST)
	public String articleUpdate(@ModelAttribute("article") Article article, BindingResult result) {
		articleFormValidator.validate(article, result);

		if (result.hasErrors()) {
			System.out.println("gata");
			return "articleUp";
		}
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String name = authentication.getName();
			article.setAuthorName(name);
			// article.setArticleId(5);
			articleService.articleUpdate(article);
			// testDAO.createArticle(article);

		} catch (DatabaseException e) {
			System.out.println("An error occured while inserting new user!");
			System.out.println("Error is:" + e);
		}

		return "redirect:/articleList";
	}
}