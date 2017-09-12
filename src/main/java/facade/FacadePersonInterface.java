package facade;

/**
 *
 * @author Christian
 */

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface FacadePersonInterface {
    public Person getPerson(Long personId, String lastName, String firstName);
    public List<Person> getPersons();
    public List<Person> getPersons(int zip);

    public void addEntityManagerFactory(EntityManagerFactory emf);        
    public EntityManager getEntityManager();
}