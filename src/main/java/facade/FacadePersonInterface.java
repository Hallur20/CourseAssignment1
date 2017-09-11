package facade;

/**
 *
 * @author Christian
 */

import entity.Person;
import java.util.List;

public interface FacadePersonInterface {
    public Person getPerson(Long personId, String lastName, String firstName);
    public Person addPerson(Person p);
    public Person deletePerson(Long personId, String lastName, String firstName);
    public Person editPerson(Person p);
    public List<Person> getPersons();
}