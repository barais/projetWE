package fr.ensai.projetWE;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.ensai.projetWE.business.Activite;
import fr.ensai.projetWE.business.ROLE;
import fr.ensai.projetWE.business.User;
import fr.ensai.projetWE.dao.UserDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		User u = new User();
		u.setDatenaissance(new Date(80, 01, 26));
		u.setNom("barais");
		u.setPrenom("Olivier");
		u.setRole(ROLE.ADMIN);

		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(u);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		UserDao dao = new UserDao();
		List<User> users = dao.getUserByName("barais");
		
		for (User u1 : users ) {
			for (Activite a : u1.getSportspreferes()) {
				System.err.println(a.getActivityname());
			}
		}
		
		
		manager.close();

    }
    
}
