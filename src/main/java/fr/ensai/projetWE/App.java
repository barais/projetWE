package fr.ensai.projetWE;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
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
		
		manager.close();
		factory.close();

    }
    
}
