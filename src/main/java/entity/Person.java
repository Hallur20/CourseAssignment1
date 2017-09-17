/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author hvn15
 */
@Entity
public class Person extends Infoentity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String firstName;
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @ManyToMany(fetch=FetchType.EAGER)
       @JoinTable(name="PERSON_HOBBY_DETAIL",
               joinColumns=
               @JoinColumn(name="PersonId", referencedColumnName="ID"),
                inverseJoinColumns=
               @JoinColumn(name="HobbyId", referencedColumnName="ID")
       )
       private List<Hobby> hobbyList; 

    public Person() {
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhones() {
        return phones;
    }

    public void setPhones(Phone phones) {
        this.phones = phones;
    }
 
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", hobbyList=" + hobbyList + '}';
    }
}
