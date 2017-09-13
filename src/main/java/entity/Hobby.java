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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hvn15
 */
@Entity
@Table(name = "HOBBY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h")
    , @NamedQuery(name = "Hobby.findByHobbyname", query = "SELECT h FROM Hobby h WHERE h.hobbyname = :hobbyname")
    , @NamedQuery(name = "Hobby.findByHobbydescription", query = "SELECT h FROM Hobby h WHERE h.hobbydescription = :hobbydescription")})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "HOBBYNAME")
    private String hobbyname;
    @Size(max = 45)
    @Column(name = "HOBBYDESCRIPTION")
    private String hobbydescription;
    @OneToMany(mappedBy = "hobbyname")
    private Collection<Person> personCollection;

    public Hobby() {
    }

    public Hobby(String hobbyname) {
        this.hobbyname = hobbyname;
    }

    public String getHobbyname() {
        return hobbyname;
    }

    public void setHobbyname(String hobbyname) {
        this.hobbyname = hobbyname;
    }

    public String getHobbydescription() {
        return hobbydescription;
    }

    public void setHobbydescription(String hobbydescription) {
        this.hobbydescription = hobbydescription;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hobbyname != null ? hobbyname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.hobbyname == null && other.hobbyname != null) || (this.hobbyname != null && !this.hobbyname.equals(other.hobbyname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hobby[ hobbyname=" + hobbyname + " ]";
    }
    
}
