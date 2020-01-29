package service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.AbstractFacade;
import dao.AuthoritiesFacade;
import dao.MemberDaoImpl;
import dao.MemberFacade;
import dao.UserFacade;
import entity.Authorities;
import entity.Member;
import entity.User;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired	
	private MemberFacade memberFacade;
    @Autowired
    private UserFacade userFacade;
    
    @Autowired
    private AuthoritiesFacade authoritiesFacade ;
    User user=new User();
	Authorities authorities=new Authorities();		
	
	String errorMessage="";


	@Override
	public String create(Member member) {
		String message="";
		try {
			String rawPassword = member.getPassword();
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(rawPassword.getBytes());
			byte[] messageDigestArray = messageDigest.digest();
			StringBuffer encodedPassword = new StringBuffer();
			for (int i = 0; i < messageDigestArray.length; i++) {
				encodedPassword.append(Integer.toString((messageDigestArray[i]&0xff)+0x100,16).substring(1));
			}
			member.setPassword(encodedPassword.toString());
			
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Ham parolanýn hashlenmesi sýrasýnda hata meydana geldi!");
			System.out.println("Hata:"+e);
		}

		

		boolean memberOperationResult = false;
		boolean userRoleOperationResult= false;
		boolean authoritiesOperationResult= false;
		try {
		memberOperationResult=memberFacade.createMember(member);
		user.setUsername(member.getName());
	    user.setPassword(member.getPassword());
	    user.setEnabled(true);
		authorities.setUsername(member.getName());
		authorities.setAuthority(member.getRole());
		
		userRoleOperationResult=userFacade.createMember(user);
		authoritiesOperationResult=  authoritiesFacade.createMember(authorities);
		}catch (DatabaseException e) {
			System.out.println("An error occured while inserting new user!");
			System.out.println("Error is:"+e);
			if(e.getInternalException().toString() == "com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException"){
				errorMessage = "Hal-i hazýrda kayýtlý e-posta adresi ile kayýt olamazsýnýz!";
			}
			System.out.println("\n\nHata mesajý burada:"+errorMessage+"\n\n");
		}
		if (memberOperationResult && userRoleOperationResult && authoritiesOperationResult) {
			message = "Üye Kaydý Baþarý Ýle Yapýldý!";
		}
		else {
			message = "Üye Kaydý Sýrasýnda Hata Meydana Geldi!"+errorMessage;
		}
		return message;

	
	}
}
