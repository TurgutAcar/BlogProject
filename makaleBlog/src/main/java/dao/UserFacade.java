package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import entity.User;
@Component
public class UserFacade extends AbstractFacade<User> {
		@PersistenceContext
		private EntityManager em;
	public UserFacade() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
