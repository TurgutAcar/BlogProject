package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import entity.Authorities;
@Component
public class AuthoritiesFacade extends AbstractFacade<Authorities> {
  @PersistenceContext
  private EntityManager em;
	public AuthoritiesFacade() {
		super(Authorities.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
