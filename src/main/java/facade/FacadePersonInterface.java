package facade;

/**
 *
 * @author Christian
 */

import entity.Person;
import java.util.List;

public interface FacadePersonInterface {
    public Person getPerson(Long personId, String lastName, String firstName);
    public List<Person> getPersons();
    public List<Person> getPersons(int zip);
}