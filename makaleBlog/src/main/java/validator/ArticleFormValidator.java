package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entity.Article;


@Component
public class ArticleFormValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Article.class.equals(clazz);
	}

	public void validate(Object arg0, Errors errors) {
		Article article = (Article) arg0;
		
		ValidationUtils.rejectIfEmpty(errors, "articleTitle", "required.articleTitle");
		ValidationUtils.rejectIfEmpty(errors, "articleContent", "required.articleContent");
		ValidationUtils.rejectIfEmpty(errors, "articleSubTitle", "required.articleSubTitle");
		ValidationUtils.rejectIfEmpty(errors, "articleDate", "required.articleDate");


		
		if(article.getArticleTitle() == null){
			errors.rejectValue("articleTitle", "required.articleTitle");
		}
		if(article.getArticleContent() == null){
			errors.rejectValue("articleContent", "required.articleContent");
		}if(article.getArticleSubTitle() == null){
			errors.rejectValue("articleSubTitle", "required.articleSubTitle");
		}if(article.getArticleDate() == null){
			errors.rejectValue("articleDate", "required.articleDate");
		}
		
	}

}
