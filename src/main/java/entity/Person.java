/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hvn15
 */
@Entity
@Table(name = "PERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByPersonid", query = "SELECT p FROM Person p WHERE p.personid = :personid")
    , @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PERSONID")
    private Integer personid;
    @Size(max = 45)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 45)
    @Column(name = "LASTNAME")
    private String lastname;
    @JoinColumn(name = "HOBBYNAME", referencedColumnName = "HOBBYNAME")
    @ManyToOne
    private Hobby hobbyname;
    @OneToMany(mappedBy = "personid")
    private Collection<Infoentity> infoentityCollection;

    public Person() {
    }

    public Person(Integer personid) {
        this.personid = personid;
    }

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Hobby getHobbyname() {
        return hobbyname;
    }

    public void setHobbyname(Hobby hobbyname) {
        this.hobbyname = hobbyname;
    }

    @XmlTransient
    public Collection<Infoentity> getInfoentityCollection() {
        return infoentityCollection;
    }

    public void setInfoentityCollection(Collection<Infoentity> infoentityCollection) {
        this.infoentityCollection = infoentityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personid != null ? personid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personid == null && other.personid != null) || (this.personid != null && !this.personid.equals(other.personid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ personid=" + personid + " ]";
    }
    
}
