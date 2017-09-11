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
        }finally{
            em.close();
        }
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        
        try{
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }finally{
        em.close();
        }
    }

    @Override
    public List<Person> getPersons(int zip) {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        
        try{
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }finally{
        em.close();
        }
    }

    
    
}
