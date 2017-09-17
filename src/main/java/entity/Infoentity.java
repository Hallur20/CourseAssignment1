/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Inheritance strategy: Mapped Superclass
 *  We chose this, since Hallur hadn't been there the first week, and it was the
 * easiest, since its mappes its own class and dosen't become an entity class
 * t merges with another. And since it is very, very simple, though the backend
 * f he coin is tha this class is no longer considered an entity class.
 */
@MappedSuperclass
public class Infoentity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AdressId", referencedColumnName = "AdressId")
    public Address address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PhoneNumber", referencedColumnName = "number")
    public Phone phones;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Infoentity(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Infoentity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infoentity)) {
            return false;
        }
        Infoentity other = (Infoentity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infoentity{" + "id=" + id + ", email=" + email + '}';
    }

}
