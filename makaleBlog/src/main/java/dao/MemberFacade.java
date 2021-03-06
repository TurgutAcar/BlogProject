package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import entity.Member;

@Component
public class MemberFacade extends AbstractFacade<Member>{
	@PersistenceContext
	private EntityManager em;
	
	public MemberFacade() {
		super(Member.class);
	}
	
	@Override
	protected EntityManager getEntityManager(){
		return em;
	}
}
