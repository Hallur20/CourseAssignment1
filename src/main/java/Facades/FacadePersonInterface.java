package Facades;

import Entity.Person;

public interface FacadePersonInterface {
    public Person getPerson(Long personId, String lastName, String firstName);
}