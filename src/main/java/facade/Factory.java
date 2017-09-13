/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Cityinfo;
import entity.Infoentity;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    public String getPersonInfo() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Person> q = em.createQuery("SELECT p FROM Person p").getResultList();
            String s = "";
            for(int i = 0; i < q.size(); i++){
                s += "personid: " + q.get(i).getPersonid();
                s += ", first_name: " + q.get(i).getFirstname();
                s += ", last_name: " + q.get(i).getLastname();
                s += ", hobby: " + q.get(i).getHobbyname().getHobbyname();
            }
            return s;
        } finally {

        }
    }
    public String getPersonContactInfo(){
        EntityManager em = emf.createEntityManager();
        try {
            List<Infoentity> q = em.createQuery("SELECT i FROM Infoentity i").getResultList();
            String s = "";
            for(int i = 0; i < q.size(); i++){
                s += "company_id: " + q.get(i).getCompanyid();
                s += ", person_id: " + q.get(i).getPersonid().getPersonid();
                s += ", email: " + q.get(i).getEmail();
                s += ", zip: " + q.get(i).getZip();
                s += ", phone_number: " + q.get(i).getPhonenumber();
                s += ", street: " + q.get(i).getStreet();
            }
            return s;
        } finally {
        }
    }

    public String getPersonInfoId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("select e from Person e where e.personid = :personid", Person.class);
            q.setParameter("personid", id);
            List<Person> list = q.getResultList();
            String s = "";
                        for(int i = 0; i < list.size(); i++){
                s += "personid: " + list.get(i).getPersonid();
                s += ", first_name: " + list.get(i).getFirstname();
                s += ", last_name: " + list.get(i).getLastname();
                s += ", hobby: " + list.get(i).getHobbyname().getHobbyname();
            }
            return s;
        } finally {

        }
    }
}
