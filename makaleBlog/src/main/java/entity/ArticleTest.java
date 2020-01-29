package entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ArticleTest {
	
    private int id;

    private String articleContent;
	
	private String articleTitle;
	
	private String authorName;
	
	@Temporal(TemporalType.DATE)
	private Date articleDate;

	 public ArticleTest() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public Date getArticleDate() {
		return articleDate;
	}


	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
	
	
	
	

}



