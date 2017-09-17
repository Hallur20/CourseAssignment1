/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.Cityinfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hallur
 */
public class Factory {

    EntityManagerFactory emf;

    public Factory() {
    }

    public Factory(EntityManagerFactory emf) {

    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /*
    *Gathers the info from the database, about the cityinfo, made by Hallur
    */
    public List<Cityinfo> getCityInfo() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Cityinfo> q = em.createQuery("select e from Cityinfo e", Cityinfo.class);
            List<Cityinfo> list = q.getResultList();
            return list;

        } finally {
            em.close();
        }
    }

    /*
    *Gathers the info from the database, about the people we've made, made by Hallur
    */
    public List<Person> getPersonInfo() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Person> q = em.createQuery("SELECT p FROM Person p").getResultList();
            return q;
        } finally {

        }
    }

    /*
    *Compares the employee numbers to the companies, made by Hallur
    */
    public List<Company> getEmployeesNum(int num) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Company> q = em.createQuery("select e.name, e.numEmployees from Company e where e.numEmployees > :num", Company.class);
            q.setParameter("num", num);
            List<Company> list = q.getResultList();
            return list;
        } finally {

        }
    }

    /*
    *Gathers the info from the database, about the companies, made by Hallur
    */
    public List<Company> getAllCompany() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Company> q = em.createQuery("select e from Company e", Company.class);
            List<Company> list = q.getResultList();
            return list;
        } finally {

        }
    }

    /*
    *Gathers people contat info, made by Hallur
    */
    public List<Person> getPersonAllContactInfo() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("select e.address, e.email, e.phones from Person e", Person.class);
            List<Person> list = q.getResultList();
            return list;
        } finally {

        }
    }

    /*
    *creates a person, made by Hallur
    */
    public void createPerson(Long id, String email, String firstname, String lastname) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person();
        p.setId(id);
        p.setEmail(email);
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setAddress(new Address(40L, "the street 4", "more", new Cityinfo("100", "beskrivelse")));
    }

    /*
    *gets an inividual persons contact info, made by Hallur
    */
    public List<Person> getPersonContactInfo(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("select e.address, e.email, e.phones from Person e where e.id = :personid", Person.class);
            q.setParameter("personid", id);
            List<Person> list = q.getResultList();
            return list;
        } finally {

        }
    }

    /*
    *Gathers people info id, made by Hallur
    */
    public List<Person> getPersonInfoId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("select e from Person e where e.id = :personid", Person.class);
            q.setParameter("personid", id);
            List<Person> list = q.getResultList();
            return list;
        } finally {

        }
    }

    /*
    *diplays the firstname of the people with a specifc hobby, made by Hallur and Christian
    */
    public List<Person> getPersonHobby(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("select e.firstName from Person e where e.id = :personid", Person.class);
            q.setParameter("personid", id);
            List<Person> li = q.getResultList();
            return li;
        } finally {

        }
    }
}
