package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import entity.Article;

@Component
public class ArticleFacade extends AbstractFacade<Article> {
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ArticleFacade() {
		super(Article.class);
	}

	public List<Article> getAllRecords(String namedQuery) {

		Query query = em.createNamedQuery(namedQuery);
		List<Article> articles = query.getResultList();
		List<Article> temp = new ArrayList<Article>();
		List<Article> temp2 = new ArrayList<Article>();

		// arrList.add(0, articles.get(0));
		// temp.add(articles.get(0));
		// temp.add(0, articles.get(3));
		// articles.remove(3);

		// articles.add(0, temp.get(0));

		// System.out.println("articles:"+temp.get(0).getArticleTitle());
		// System.out.println("articles:"+articles.get(0).getArticleTitle());
		// System.out.println("articles:"+articles.get(1).getArticleTitle());
		// System.out.println("articles:"+articles.get(2).getArticleTitle());
		// System.out.println("articles:"+articles.get(3).getArticleTitle());
		// System.out.println("articles:"+articles.get(4).getArticleTitle());

		System.out.println("size=" + articles.size());
		int k = 0;
		// Collections.sort(articles, new Article());
		// articles.sort(Comparator.comparing(o ->
		// articles.get(0).setArticleDate(date)));

		for (int i = 1; i < articles.size(); i++) {
			for (int j = 0; j < articles.size() - i; j++) {
				if (articles.get(j).getArticleDate().before(articles.get(j + 1).getArticleDate())) {
					temp.add(k, articles.get(j));
					// temp2.add(k, articles.get(j+1));
					articles.remove(j);
					// articles.add(j, temp2.get(k));
					articles.add(j + 1, temp.get(k));
					temp.remove(k);
					// temp2.remove(k);// 60,40,20,50

					// 15.02.2020 ,01.03.2021,18.02.2008 05.05.2000
					// 01.03.2021 , 15.02.2020,18.02.2008 ,05.
				}

			}
		}
		// System.out.println("articles:"+articles.get(0).getArticleTitle());
		// System.out.println("articles:"+articles.get(1).getArticleTitle());
		// System.out.println("articles:"+articles.get(2).getArticleTitle());
		// System.out.println("articles:"+articles.get(3).getArticleTitle());

		return articles;

	}

	@Transactional
	public void update(Article entity) {
		try {
			em.merge(entity);
		} catch (PersistenceException ex) {
			Throwable t = getLastThrowable(ex); // fetching Internal Exception
			SQLException exxx = (SQLException) t; // casting Throwable object to SQL Exception
			System.out.println(exxx.getSQLState());

			// Integrity constraint violation
		}
	}

	@Transactional
	public Article ArticleSingle(int articleId) {
		Article article = getEntityManager().find(Article.class, articleId);
		// System.out.println("date="+article.getArticleDate());

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
		// String date = sdf.format(article.getArticleDate());
		// System.out.println("tarih:"+date);
		/*
		 * 
		 * 
		 * try {
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd"); String date =
		 * sdf.format(article.getArticleDate()); java.util.Date date1= sdf.parse(date);
		 * Calendar calendar =Calendar.getInstance(); calendar.setTime(date);
		 * 
		 * 
		 * date1 = new SimpleDateFormat("yyyy/M/dd").parse(date);
		 * System.out.println("date1="+calendar.getTime());
		 * 
		 * article.setArticleDate(date1);
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * System.out.println("date2="+article.getArticleDate());
		 * 
		 * /* //TimeZone.setDefault(TimeZone.getTimeZone("America/New_York")); Timestamp
		 * timestamp = new Timestamp(new Date(articleId).getTime());
		 * System.out.println("date:"+timestamp);
		 * 
		 * 
		 * //long date= article.getArticleDate().getTime();
		 * 
		 * // java.sql.Date date=new java.sql.Date(article.getArticleDate());
		 * 
		 * /*try { String dt = "Wed Oct 27 00:00:00 EEST 2010"; SimpleDateFormat format
		 * = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy"); java.util.Date date;
		 * date = format.parse(dt); System.out.println("date = " + date);
		 * 
		 * } catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } // System.out.println("date="+);
		 */

		return article;
	}

	private static Throwable getLastThrowable(Exception e) {
		Throwable t = null;
		for (t = e.getCause(); t.getCause() != null; t = t.getCause())
			;
		return t;
	}
}
