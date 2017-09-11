package facade;

/**
 *
 * @author Christian
 */

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacadePerson implements FacadePersonInterface {
    
    private EntityManagerFactory emf;
    
    public FacadePerson(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public Person getPerson(Long personId, String lastName, String firstName) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Person person = em.find(Person.class, personId);
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }
    
    
}
