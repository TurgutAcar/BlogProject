package dao;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import javax.persistence.RollbackException;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;
import entity.Authorities;
import entity.User;

@Component
public class MemberDaoImpl {
	@PersistenceContext
	private EntityManager em;
      
	@Transactional
	public void create(Member member) {
		User user=new User();
		Authorities authorities=new Authorities();		
		
		
		try {
			user.setUsername(member.getName());
			user.setPassword(member.getPassword());
			user.setEnabled(true);
			authorities.setUsername(member.getName());
			authorities.setAuthority(member.getRole());
			em.persist(authorities);
			em.persist(user);
			em.persist(member);
			}catch(PersistenceException ex) {
				Throwable t = getLastThrowable(ex);  //fetching Internal Exception
				SQLException exxx = (SQLException) t;  //casting Throwable object to SQL Exception
				System.out.println(exxx.getSQLState());

				  // Integrity constraint violation
			}		
		
	}

	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMember(int memberId) {
		// TODO Auto-generated method stub

	}
	private static Throwable getLastThrowable(Exception e) {
		Throwable t = null;
		for(t = e.getCause(); t.getCause() != null; t = t.getCause());
		return t;
		} 
		

}
