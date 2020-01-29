package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import entity.Article;
import entity.Authorities;
import entity.User;

public abstract class AbstractFacade<T> {
	private Class<T> entityClass;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEntityManager();
	
	@Transactional
	public boolean create(T entity) {
		boolean isOperationSuccessful = false;
		try {
			getEntityManager().persist(entity);
			isOperationSuccessful =true;
		} catch (RollbackException e) {
			isOperationSuccessful = false;
		}
		return isOperationSuccessful;
	
	}
	@Transactional
	public boolean createMember(T entity){
		boolean isOperationSuccessful = false;
		try {
			getEntityManager().persist(entity);
			isOperationSuccessful =true;
		} catch (RollbackException e) {
			isOperationSuccessful = false;
		}
		return isOperationSuccessful;
	}
	
	
	
	
	
	@Transactional
	public List<T> getAllRecords(String namedQuery){


		Query query = getEntityManager().createNamedQuery(namedQuery);
		
		
		
		return query.getResultList();
	}
	@Transactional
	public void delete(int id) {
		
		Article article=getEntityManager().find(Article.class, id);
		getEntityManager().remove(article);
	}
	
	
	private static Throwable getLastThrowable(Exception e) {
		Throwable t = null;
		for(t = e.getCause(); t.getCause() != null; t = t.getCause());
		return t;
		} 
		
	
	
	
	
	
	
	

}
