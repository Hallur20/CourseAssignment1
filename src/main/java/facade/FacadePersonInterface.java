package facade;

/**
 *
 * @author Christian
 */

import entity.Person;

public interface FacadePersonInterface {
    public Person getPerson(Long personId, String lastName, String firstName);
}