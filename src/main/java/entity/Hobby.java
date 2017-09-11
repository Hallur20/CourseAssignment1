/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hallur
 */
@Entity
@Table(name = "HOBBY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h")
    , @NamedQuery(name = "Hobby.findByHobbyid", query = "SELECT h FROM Hobby h WHERE h.hobbyid = :hobbyid")
    , @NamedQuery(name = "Hobby.findByHobbyname", query = "SELECT h FROM Hobby h WHERE h.hobbyname = :hobbyname")
    , @NamedQuery(name = "Hobby.findByHobbydescription", query = "SELECT h FROM Hobby h WHERE h.hobbydescription = :hobbydescription")})
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOBBYID")
    private Integer hobbyid;
    @Size(max = 45)
    @Column(name = "HOBBYNAME")
    private String hobbyname;
    @Size(max = 80)
    @Column(name = "HOBBYDESCRIPTION")
    private String hobbydescription;
    @JoinColumn(name = "PERSONID", referencedColumnName = "PERSONID")
    @ManyToOne
    private Person personid;

    public Hobby() {
    }

    public Hobby(Integer hobbyid) {
        this.hobbyid = hobbyid;
    }

    public Integer getHobbyid() {
        return hobbyid;
    }

    public void setHobbyid(Integer hobbyid) {
        this.hobbyid = hobbyid;
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

    public Person getPersonid() {
        return personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hobbyid != null ? hobbyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.hobbyid == null && other.hobbyid != null) || (this.hobbyid != null && !this.hobbyid.equals(other.hobbyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hobby[ hobbyid=" + hobbyid + " ]";
    }
    
}
