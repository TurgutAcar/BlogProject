package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import entity.Article;
@Component
public class ArticleDaoImpl implements ArticleDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public void createArticle(Article article) {
		
		
		try {
			em.persist(article);

			}catch(PersistenceException ex) {
				Throwable t = getLastThrowable(ex);  //fetching Internal Exception
				SQLException exxx = (SQLException) t;  //casting Throwable object to SQL Exception
				System.out.println(exxx.getSQLState());

				  // Integrity constraint violation
			}
	}

	
	
	private static Throwable getLastThrowable(Exception e) {
		Throwable t = null;
		for(t = e.getCause(); t.getCause() != null; t = t.getCause());
		return t;
		} 

}
